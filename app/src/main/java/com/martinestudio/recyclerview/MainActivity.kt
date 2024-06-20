package com.martinestudio.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList:ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myRecyclerView = findViewById(R.id.recyclerView)
        val newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
            R.drawable.img11,
            R.drawable.img12,
            R.drawable.img13,
            R.drawable.img14,
            R.drawable.img15,
            R.drawable.img16)

        val newsHeadingArray = arrayOf("Pawar says sensible voters foiled attempt for dictatorship in the country",
            "Barfiwala flyover and Gokhale Bridge connection to be open to vehicles from July 1",
            "3 Indians, 4 Egyptians detained in connection with massive fire that killed 50 people in Kuwait",
            "Amid NEET row, Centre cancels UGC-NET exam, says ‘integrity may have been compromised",
            "Kanchenjunga Express accident: How Indian Railways can put a stop to fatal collisions",
            "Shiv Sena (UBT) Lok Sabha poll win like a ‘swelling’, it will go away soon, says CM Shinde",
            "Odisha mishap third major train accident in 3 decades; A look at past incidents",
            "Glimpses of 75th Republic Day Celebrated in India",
            "Cabinet approves Central Sector Scheme “National Forensic Infrastructure Enhancement Scheme” (N.F.l.E.S.)",
            "Sonakshi Sinha’s brother Luv on her wedding with Zaheer Iqbal: ‘I have no comment or involvement…’",
            "Deepika Padukone jokingly points at her growing baby bump an..",
            "Bihar govt directs all districts and hospitals to increase COVID19 RTPCR testing with random testing of arrivals at Patna, Gaya and Darbhanga airports",
            "India News | Random Testing Underway to Check Use of Formalin in Fish Market: Tripura Fishery Minister",
            "Inter Miami vs Columbus Crew, MLS 2024 Live Streaming Online in India: How to Watch Football Match Live Telecast on TV & Score Updates in IST?",
            "ICC T20 World Cup 2024 Points Table Super Eight: South Africa Occupy Top Spot in Group 2 After Win Over USA",
            "Quinton de Kock Wins Man of the Match Award in South Africa vs USA ICC T20 World Cup 2024 Super Eight Match"
        )

        val newsContent = arrayOf(
            getString(R.string.news_content1),
            getString(R.string.news_content2),
            getString(R.string.news_content1),
            getString(R.string.news_content2),
            getString(R.string.news_content1),
            getString(R.string.news_content2),
            getString(R.string.news_content1),
            getString(R.string.news_content2),
            getString(R.string.news_content1),
            getString(R.string.news_content2),
            getString(R.string.news_content1),
            getString(R.string.news_content2),
            getString(R.string.news_content1),
            getString(R.string.news_content2),
            getString(R.string.news_content1),
            getString(R.string.news_content2)


        )


        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()
        for(index in newsImageArray.indices){
            val news = News(newsHeadingArray[index],newsImageArray[index],newsContent[index])
            newsArrayList.add(news)
        }

        var myAdapter = MyAdapter(newsArrayList,this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setItemClickListener(object:MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                // on clicking
                var intent = Intent(applicationContext,NewsDetailActivity::class.java)

                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("imageId",newsArrayList[position].newsImage)
                intent.putExtra("newscontent",newsArrayList[position].newsContent)
                startActivity(intent)
            }

        })


    }
}