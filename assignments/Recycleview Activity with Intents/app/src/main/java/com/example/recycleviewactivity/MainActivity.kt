package com.example.recycleviewactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapters = mutableListOf<RecyclerAdapter>()
        for (i in 1..8) {
            val randomChapter = Data.getRandomChapter()
            val adapter = RecyclerAdapter(randomChapter, this)
            adapters.add(adapter)
        }

        val concatAdapter = ConcatAdapter(adapters)
        recyclerView.adapter = concatAdapter
    }

    override fun onItemClick(chapter: Triple<String, String, Int>) {
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra("title", chapter.first)
            putExtra("detail", chapter.second)
            putExtra("image", chapter.third)
        }
        startActivity(intent)
    }
}
