package com.example.vosmik.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vosmik.R
import kotlinx.android.synthetic.main.example_item.view.*
/*
class NewsAdapter(private val newsList: List<ExampleItem>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.example_item,
            parent, false)
        return NewsViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.textView1.text = currentItem.About
        holder.textView2.text = currentItem.Lorem
    }
    override fun getItemCount() = newsList.size
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.about
        val textView2: TextView = itemView.lorem
    }
}*/