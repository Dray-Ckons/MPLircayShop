package com.example.mplircayshop.oneapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mplircayshop.R
import com.example.mplircayshop.oneapp.adapter.Productos3Adapter
import com.example.mplircayshop.oneapp.Productos3Provider

class TercerFragment : Fragment() {
    private var name: String? = null
    private var adress: String? = null
    private var sortedByAscending = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME_BUNDLE)
            adress = it.getString(ADRESS_BUNDLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tercer, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycleProductos3)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = Productos3Adapter(Productos3Provider.productos3List.toMutableList())
        recyclerView.adapter = adapter

        val searchEditText = view.findViewById<EditText>(R.id.searchEditText)
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // No se necesita implementar nada aquí
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No se necesita implementar nada aquí
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter.filter(s)
            }
        })

        setupSortButton(view, adapter)
    }

    private fun setupSortButton(view: View, adapter: Productos3Adapter) {
        view.findViewById<ImageButton>(R.id.sortButton).setOnClickListener {
            if (sortedByAscending) {
                adapter.updateList(Productos3Provider.productos3List.sortedByDescending { it.valor })
            } else {
                adapter.updateList(Productos3Provider.productos3List.sortedBy { it.valor })
            }
            sortedByAscending = !sortedByAscending
        }
    }

    companion object {
        private const val NAME_BUNDLE = "param1"
        private const val ADRESS_BUNDLE = "param2"

        @JvmStatic
        fun newInstance(name: String, address: String) = TercerFragment().apply {
            arguments = Bundle().apply {
                putString(NAME_BUNDLE, name)
                putString(ADRESS_BUNDLE, address)
            }
        }
    }
}

