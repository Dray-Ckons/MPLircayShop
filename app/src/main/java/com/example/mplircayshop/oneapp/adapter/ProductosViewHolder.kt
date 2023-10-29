package com.example.mplircayshop.oneapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mplircayshop.R
import com.example.mplircayshop.oneapp.Productos

class ProductosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val nombreLista: TextView = view.findViewById(R.id.ivProductoName)
    private val cantidadProductos: TextView = view.findViewById(R.id.ivProductoCant)
    private val numLista: TextView = view.findViewById(R.id.ivProductoNum)

    fun render(productosModel: Productos) {
        nombreLista.text = productosModel.nombre_lista
        cantidadProductos.text = productosModel.cantidad_productos
        numLista.text = productosModel.num_lista.toString()

        itemView.setOnClickListener {
            Toast.makeText(itemView.context, productosModel.nombre_lista, Toast.LENGTH_SHORT).show()
        }
    }
}

