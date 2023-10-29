package com.example.mplircayshop.oneapp.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mplircayshop.oneapp.Productos2
import com.example.mplircayshop.oneapp.Productos2Provider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.widget.TextView
import com.example.mplircayshop.R

class Productos2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val nombre: TextView = view.findViewById(R.id.ivProductoName2)
    private val tipo_cantidad: TextView = view.findViewById(R.id.ivProductoTipo2)
    private val cantidad: TextView = view.findViewById(R.id.ivProductoCantidad2)
    private val botonMas: FloatingActionButton = view.findViewById(R.id.id_botonmas)
    private val botonMenos: FloatingActionButton = view.findViewById(R.id.id_botonmenos)

    fun render(productos2Model: Productos2) {
        nombre.text = productos2Model.nombre
        tipo_cantidad.text = productos2Model.tipo_cantidad
        cantidad.text = productos2Model.cantidad.toString()

        botonMas.setOnClickListener {
            productos2Model.aumentarCantidad()
            cantidad.text = productos2Model.cantidad.toString()
        }

        botonMenos.setOnClickListener {
            if (productos2Model.cantidad > 0) {
                productos2Model.disminuirCantidad()
                cantidad.text = productos2Model.cantidad.toString()
            } else {
                Toast.makeText(itemView.context, "La cantidad no puede ser negativa", Toast.LENGTH_SHORT).show()
            }
        }
    }
}




