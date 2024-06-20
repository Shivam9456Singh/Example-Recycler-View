package com.martinestudio.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter (var newsArrayList:ArrayList<News>, var context:Activity):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

        private lateinit var myListener: onItemClickListener

        interface onItemClickListener{
            fun onItemClick(position: Int)

        }

    fun setItemClickListener(listener : onItemClickListener){
        this.myListener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView,myListener)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.hTitle.text = currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)
    }

    override fun getItemCount(): Int {

        return newsArrayList.size
    }

    class MyViewHolder(itemView:View,listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        var hTitle = itemView.findViewById<TextView>(R.id.headingTitle)
        var hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }

}