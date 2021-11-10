package com.example.weekfouranimation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter (val arrayList: ArrayList<Model>, val context: Context):
    RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: Model){

            itemView.findViewById<TextView>(R.id.titleTv).text = model.title
            itemView.findViewById<TextView>(R.id.birthday).text = model.birth
            itemView.findViewById<TextView>(R.id.days_left).text = model.days
            itemView.findViewById<ImageView>(R.id.imageCard).setImageResource(model.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cards =  LayoutInflater.from(parent.context).inflate(R.layout.recycler_page, parent, false)
        return ViewHolder(cards)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

}