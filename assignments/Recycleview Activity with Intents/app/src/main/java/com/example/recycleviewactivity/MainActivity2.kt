package com.example.recycleviewactivity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val title = intent.getStringExtra("title") ?: ""
        val detail = intent.getStringExtra("detail") ?: ""
        val imageRes = intent.getIntExtra("image", 0)

        findViewById<TextView>(R.id.item_title).text = title
        findViewById<TextView>(R.id.item_detail).text = detail
        findViewById<ImageView>(R.id.item_image).setImageResource(imageRes)
    }
}
