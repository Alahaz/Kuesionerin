package com.ziesapp.kuesionerin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.ziesapp.kuesionerin.data.Item
import com.ziesapp.kuesionerin.databinding.ActivityAddBinding
import com.ziesapp.kuesionerin.databinding.ActivityMainBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.elevation = 0F
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.btnSubmit.setOnClickListener {
           var title = binding.tfTitle.editText?.text.toString()
           var description = binding.tfDesc.editText?.text.toString()
           var link = binding.tfLink.editText?.text.toString()

           val items = hashMapOf(
               "title" to title,
               "description" to description,
               "link" to link
           )

           db.collection("items")
               .add(items)
               .addOnSuccessListener { documentReference -> Log.d("inilog","DocumentSnapshot added with ID: ${documentReference.id}")
               Toast.makeText(this,"Kuesioner berhasil di upload :)",Toast.LENGTH_SHORT).show()
               }
           startActivity(Intent(this,MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
           finish()
       }

    }
}