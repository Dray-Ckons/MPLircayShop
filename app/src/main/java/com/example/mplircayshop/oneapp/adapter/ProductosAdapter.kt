package com.example.mplircayshop.oneapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.example.mplircayshop.R
import com.example.mplircayshop.oneapp.Productos
import com.example.mplircayshop.oneapp.Productos2Provider
import com.example.mplircayshop.oneapp.SegundoFragment

class ProductosAdapter(private var productosList: MutableList<Productos>) : RecyclerView.Adapter<ProductosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductosViewHolder(layoutInflater.inflate(R.layout.item_productos, parent, false))
    }

    override fun getItemCount(): Int = productosList.size

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
        val item = productosList[position]
        holder.render(item)

        holder.itemView.setOnClickListener {
            val numLista = item.num_lista
            val productos2List = Productos2Provider.getProductos2ListForItem(numLista) // Asumiendo que tienes un método en Productos2Provider para obtener la lista correspondiente de productos2List
            val fragment = SegundoFragment.newInstance("", "", productos2List)
            val fragmentManager = (it.context as AppCompatActivity).supportFragmentManager
            fragmentManager.commit {
                replace(R.id.frameContainer, fragment)
                addToBackStack(null)
            }
        }
    }

    fun addProducto(producto: Productos) {
        productosList.add(producto)
        notifyDataSetChanged()
    }
}
