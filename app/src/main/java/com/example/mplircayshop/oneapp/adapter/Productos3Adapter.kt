package com.example.mplircayshop.oneapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.mplircayshop.R
import com.example.mplircayshop.oneapp.Productos3
import com.example.mplircayshop.oneapp.adapter.Productos3ViewHolder

class Productos3Adapter(private var productos3List: MutableList<Productos3>) :
    RecyclerView.Adapter<Productos3ViewHolder>(), Filterable {

    private var productos3ListFull: List<Productos3> = productos3List.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Productos3ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Productos3ViewHolder(layoutInflater.inflate(R.layout.item_productos3, parent, false))
    }

    override fun getItemCount(): Int = productos3List.size

    override fun onBindViewHolder(holder: Productos3ViewHolder, position: Int) {
        val item = productos3List[position]
        holder.render(item)
    }

    fun updateList(newList: List<Productos3>) {
        productos3List.clear()
        productos3List.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredList: MutableList<Productos3> = mutableListOf()
                if (constraint.isNullOrBlank()) {
                    filteredList.addAll(productos3ListFull)
                } else {
                    val filterPattern = constraint.toString().toLowerCase().trim()
                    for (item in productos3ListFull) {
                        if (item.nombre.toLowerCase().contains(filterPattern)) {
                            filteredList.add(item)
                        }
                    }
                }
                val results = FilterResults()
                results.values = filteredList
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                productos3List.clear()
                productos3List.addAll(results?.values as List<Productos3>)
                notifyDataSetChanged()
            }
        }
    }
}

