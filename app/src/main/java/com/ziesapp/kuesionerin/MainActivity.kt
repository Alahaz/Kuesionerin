package com.ziesapp.kuesionerin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ziesapp.kuesionerin.adapter.ItemAdapter
import com.ziesapp.kuesionerin.data.Item
import com.ziesapp.kuesionerin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Item>()

    //Firebase
    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        supportActionBar!!.elevation = 0F
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.setHasFixedSize(true)
        getListData()
    }

    private fun getListData() {
        db.collection("items")
            .get()
            .addOnSuccessListener {
                list.clear()
                for (snapshot in it) {
                    list.add(
                        (
                                Item(
                                    snapshot.data["title"] as String,
                                    snapshot.data["description"] as String,
                                    snapshot.data["link"] as String
                                ))
                    )
                }
                val itemAdapter = ItemAdapter(list)
                binding.rvMain.setHasFixedSize(true)
                binding.rvMain.layoutManager = LinearLayoutManager(this)
                binding.rvMain.adapter = itemAdapter
            }
            .addOnFailureListener {
                Log.v("inilog", "Gagal mengambil data")
            }
    }
}