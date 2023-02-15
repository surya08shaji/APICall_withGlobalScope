package com.example.globalscope

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.globalscope.data.model.ResultModel


class Adapter(private val mList: List<ResultModel>?) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val author: TextView = itemView.findViewById(R.id.author)
        val content: TextView = itemView.findViewById(R.id.content)
        val length: TextView = itemView.findViewById(R.id.length)
        val dateAdded: TextView = itemView.findViewById(R.id.dateAdded)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_row, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = mList?.get(position)
        if (items != null) {
            holder.author.text = items.author
            holder.content.text = items.content
            holder.length.text = items.length.toString()
            holder.dateAdded.text = items.dateAdded
        }


    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }
}
