package com.example.recycleviewactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private val chapter: Triple<String, String, Int>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chapter)
    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val itemImage: ImageView = itemView.findViewById(R.id.item_image)
        private val itemTitle: TextView = itemView.findViewById(R.id.item_title)
        private val itemDetail: TextView = itemView.findViewById(R.id.item_detail)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(chapter: Triple<String, String, Int>) {
            itemTitle.text = chapter.first
            itemDetail.text = chapter.second
            itemImage.setImageResource(chapter.third)
        }

        override fun onClick(v: View?) {
            listener.onItemClick(chapter)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(chapter: Triple<String, String, Int>)
    }
}
