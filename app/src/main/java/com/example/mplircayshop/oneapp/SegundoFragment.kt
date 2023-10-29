package com.example.mplircayshop.oneapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mplircayshop.R
import com.example.mplircayshop.oneapp.adapter.Productos2Adapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.Serializable

class SegundoFragment : Fragment() {

    private var name: String? = null
    private var address: String? = null
    private var productos2List: List<Productos2>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME_BUNDLE)
            address = it.getString(ADDRESS_BUNDLE)
            productos2List = it.getSerializable(PRODUCTOS_2_LIST) as? List<Productos2>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_segundo, container, false)
        initRecyclerView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycleProductos2)
        val agregar2Button: FloatingActionButton = view.findViewById(R.id.Agregar2)

        val productos2Adapter = productos2List?.let { Productos2Adapter(it.toMutableList()) }
        recyclerView.adapter = productos2Adapter

        agregar2Button.setOnClickListener {
            val nuevoProducto = Productos2(
                nombre = "Nuevo Producto",
                tipo_cantidad = "Nuevo Tipo de Cantidad",
                cantidad = 0
            )
            productos2Adapter?.addProducto(nuevoProducto)
        }
    }

    private fun initRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycleProductos2)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        productos2List?.let { recyclerView.adapter = Productos2Adapter(it.toMutableList()) }
    }

    companion object {
        private const val NAME_BUNDLE = "name"
        private const val ADDRESS_BUNDLE = "address"
        private const val PRODUCTOS_2_LIST = "productos2List"

        @JvmStatic
        fun newInstance(name: String, address: String, productos2List: List<Productos2>): SegundoFragment {
            val fragment = SegundoFragment()
            val args = Bundle()
            args.putString(NAME_BUNDLE, name)
            args.putString(ADDRESS_BUNDLE, address)
            args.putSerializable(PRODUCTOS_2_LIST, productos2List as Serializable)
            fragment.arguments = args
            return fragment
        }
    }
}














