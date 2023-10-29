package com.example.mplircayshop.oneapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mplircayshop.R
import com.example.mplircayshop.oneapp.adapter.ProductosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.*

class PrimerFragment : Fragment() {

    private var name: String? = null
    private var address: String? = null
    private var productosList: MutableList<Productos>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME_BUNDLE)
            address = it.getString(ADDRESS_BUNDLE)
            productosList = arguments?.getSerializable(PRODUCTOS_LIST) as? MutableList<Productos>
        }
        if (productosList == null) {
            productosList = readData() ?: ProductosProvider.productosList.toMutableList()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_primer, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycleProductos)
        val agregarButton: FloatingActionButton = view.findViewById(R.id.Agregar1)

        val productosAdapter = ProductosAdapter(productosList!!)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = productosAdapter

        agregarButton.setOnClickListener {
            val nuevoProducto = Productos(
                nombre_lista = "Nueva Lista numero: ${productosAdapter.itemCount + 1}",
                cantidad_productos = "Cantidad de Productos en la lista ",
                num_lista = productosAdapter.itemCount + 1
            )
            productosList?.add(nuevoProducto)
            productosAdapter.notifyItemInserted(productosList!!.size - 1)
            saveData(productosList!!)
        }
    }

    companion object {
        private const val NAME_BUNDLE = "name"
        private const val ADDRESS_BUNDLE = "address"
        private const val PRODUCTOS_LIST = "productosList"

        private const val FILENAME = "productos_data.txt"

        @JvmStatic
        fun newInstance(name: String, address: String, productosList: List<Productos>): PrimerFragment {
            val fragment = PrimerFragment()
            val args = Bundle().apply {
                putString(NAME_BUNDLE, name)
                putString(ADDRESS_BUNDLE, address)
                putSerializable(PRODUCTOS_LIST, ArrayList(productosList))
            }
            fragment.arguments = args
            return fragment
        }
    }

    private fun saveData(productosList: List<Productos>) {
        try {
            val file = File(context?.filesDir, FILENAME)
            val fileOutputStream = FileOutputStream(file)
            val objectOutputStream = ObjectOutputStream(fileOutputStream)
            objectOutputStream.writeObject(productosList)
            objectOutputStream.close()
            fileOutputStream.close()
            Log.d("PrimerFragment", "Datos guardados con éxito: $productosList")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun readData(): MutableList<Productos>? {
        var productosList: MutableList<Productos>? = null
        try {
            val file = File(context?.filesDir, FILENAME)
            val fileInputStream = FileInputStream(file)
            val objectInputStream = ObjectInputStream(fileInputStream)
            productosList = objectInputStream.readObject() as MutableList<Productos>?
            objectInputStream.close()
            fileInputStream.close()
            Log.d("PrimerFragment", "Datos leídos con éxito: $productosList")
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        return productosList
    }

}




