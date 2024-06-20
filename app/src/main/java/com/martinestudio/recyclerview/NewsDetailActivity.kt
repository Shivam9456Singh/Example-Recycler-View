package com.martinestudio.recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val heading = intent.getStringExtra("heading")
        val imageId = intent.getIntExtra("imageId",0)
        val newsContent = intent.getStringExtra("newscontent")

        val newsImage = findViewById<ImageView>(R.id.newsImage)
        val newsHeading = findViewById<TextView>(R.id.newsHeading)
        val newsContentView = findViewById<TextView>(R.id.newsContent)

        newsImage.setImageResource(imageId)
        newsHeading.text = heading
        newsContentView.text = newsContent

    }
}