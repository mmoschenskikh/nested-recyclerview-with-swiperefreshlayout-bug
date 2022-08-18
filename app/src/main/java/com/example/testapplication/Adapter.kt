package com.example.testapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class Adapter : RecyclerView.Adapter<ViewHolder>() {
    private val items = Array(100) { Any() }
    private val random = Random()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
        holder.view.setBackgroundColor(randomColor)
        if (position == 0) {
            holder.innerList.adapter = Adapter().apply { notifyDataSetChanged() }
        }
        holder.innerList.isVisible = (position == 0)
    }

    override fun getItemCount() = items.size
}

class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val innerList: RecyclerView = view.findViewById(R.id.innerList)
}
