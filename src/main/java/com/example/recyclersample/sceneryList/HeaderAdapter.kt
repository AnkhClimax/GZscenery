
package com.example.recyclersample.sceneryList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.R


class HeaderAdapter: RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    private var sceneryCount: Int = 0

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val sceneryNumberTextView: TextView = itemView.findViewById(R.id.scenery_number_text)

        fun bind(sceneryCount: Int) {
            sceneryNumberTextView.text = sceneryCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.header_item, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(sceneryCount)
    }

    override fun getItemCount(): Int {
        return 1
    }

    fun updateSceneryCount(updatedSceneryCount: Int) {
        sceneryCount = updatedSceneryCount
        notifyDataSetChanged()
    }
}