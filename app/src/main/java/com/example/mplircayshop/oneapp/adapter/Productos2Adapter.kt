package com.example.mplircayshop.oneapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mplircayshop.R
import com.example.mplircayshop.oneapp.Productos2

class Productos2Adapter(private val productos2List: MutableList<Productos2>) : RecyclerView.Adapter<Productos2ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Productos2ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Productos2ViewHolder(layoutInflater.inflate(R.layout.item_productos2, parent, false ))

    }

    override fun getItemCount(): Int = productos2List.size

    override fun onBindViewHolder(holder: Productos2ViewHolder, position: Int) {

        val item = productos2List[position]
        holder.render(item)

    }

    fun addProducto(producto: Productos2) {
        productos2List.add(producto)
        notifyDataSetChanged()
    }

}