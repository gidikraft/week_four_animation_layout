package com.example.weekfouranimation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter (

    val images: List<Int>
    ): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
        inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView ) {

            private val celebrantImageView: ImageView = itemView.findViewById(R.id.iv_pager)

            fun bind(image: Int) {
                celebrantImageView.setImageResource(image)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
            return ViewPagerViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
            val curImage = images[position]
            holder.bind(curImage)
        }

        override fun getItemCount(): Int {
            return images.size
        }
}