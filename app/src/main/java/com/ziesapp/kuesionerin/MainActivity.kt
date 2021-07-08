package com.ziesapp.kuesionerin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ziesapp.kuesionerin.adapter.ItemAdapter
import com.ziesapp.kuesionerin.data.Item
import com.ziesapp.kuesionerin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        supportActionBar!!.elevation = 0F

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.setHasFixedSize(true)
        list.addAll(getListData())
        showRecyler()
    }

    private fun getListData(): Collection<Item> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val dataLink = resources.getStringArray(R.array.data_link)

        val listItem = ArrayList<Item>()
        for(position in dataTitle.indices){
            val item = Item(
                dataTitle[position],
                dataDesc[position],
                dataLink[position]
            )
            listItem.add(item)
        }
        return listItem
    }

    private fun showRecyler() {
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        val itemAdapter = ItemAdapter(list)
        binding.rvMain.adapter = itemAdapter
    }
}