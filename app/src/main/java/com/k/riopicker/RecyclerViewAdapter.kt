package com.k.riopicker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *Create by Petr on 29.06.2021
 */
class RecyclerViewAdapter(private var numberList: ArrayList<NumberItem>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.number_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(numberList[position])
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(numberItem: NumberItem) {
            val textViewNumber = itemView.findViewById(R.id.number_txt) as TextView
            textViewNumber.text = numberItem.number.toString()
        }
    }
}


