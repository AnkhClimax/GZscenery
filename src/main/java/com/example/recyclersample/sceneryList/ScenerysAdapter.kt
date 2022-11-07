
package com.example.recyclersample.sceneryList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.R
import com.example.recyclersample.data.Scenery

class ScenerysAdapter(private val onClick: (Scenery) -> Unit) :
    ListAdapter<Scenery, ScenerysAdapter.SceneryViewHolder>(SceneryDiffCallback) {

    class SceneryViewHolder(itemView: View, val onClick: (Scenery) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val sceneryTextView: TextView = itemView.findViewById(R.id.scenery_text)
        private val sceneryImageView: ImageView = itemView.findViewById(R.id.scenery_image)
        private var currentScenery: Scenery? = null

        init {
            itemView.setOnClickListener {
                currentScenery?.let {
                    onClick(it)
                }
            }
        }

        /* Bind flower name and image. */
        fun bind(scenery: Scenery) {
            currentScenery = scenery

            sceneryTextView.text = scenery.name
            if (scenery.image != null) {
                sceneryImageView.setImageResource(scenery.image)
            } else {
                sceneryImageView.setImageResource(R.drawable.zjxc)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SceneryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.scenery_item, parent, false)
        return SceneryViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: SceneryViewHolder, position: Int) {
        val scenery = getItem(position)
        holder.bind(scenery)

    }
}

object SceneryDiffCallback : DiffUtil.ItemCallback<Scenery>() {
    override fun areItemsTheSame(oldItem: Scenery, newItem: Scenery): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Scenery, newItem: Scenery): Boolean {
        return oldItem.id == newItem.id
    }
}