package com.example.mplircayshop.oneapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mplircayshop.R
import com.example.mplircayshop.oneapp.Productos3

class Productos3ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val nombre: TextView = view.findViewById(R.id.ivProductoName3)
    private val tipo_cantidad: TextView = view.findViewById(R.id.ivProductoTipo3)
    //private val foto: ImageView = view.findViewById(R.id.ivProductoImagen)
    private val precio: TextView = view.findViewById(R.id.ivProductoPrecio3)

    fun render(productos3Model: Productos3) {
        nombre.text = productos3Model.nombre
        tipo_cantidad.text = productos3Model.tipo_cantidad
        //foto.("@drawable/$foto") //error
        precio.text = productos3Model.precio


        itemView.setOnClickListener { Toast.makeText( itemView.context , productos3Model.nombre, Toast.LENGTH_SHORT).show() }

    }
}
