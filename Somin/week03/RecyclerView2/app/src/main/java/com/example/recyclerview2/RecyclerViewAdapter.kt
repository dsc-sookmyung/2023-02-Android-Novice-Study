package com.example.recyclerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.databinding.ListItemBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Collections

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val dataset: ArrayList<List<String>> = arrayListOf<List<String>>().apply {
        for (i in 0..99) {
            add(listOf("$i th main", "$i th sub"))
        }
    }

    fun removeData(position: Int) {
        dataset.removeAt(position)
        notifyItemRemoved(position)
    }

    fun swapData(fromPos: Int, toPos: Int) {
        Collections.swap(dataset, fromPos, toPos)
        notifyItemMoved(fromPos, toPos)
    }

    fun setData(position: Int) {
        dataset[position] = listOf("main viewholder touched!", "sub viewholder touched!")
        notifyItemChanged(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    inner class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: List<String>) {
            binding.tvMain.text = data[0]
            binding.tvSub.text = data[1]

            binding.vhLayout.setOnClickListener {
                Snackbar.make(it, "Item $layoutPosition touched!", Snackbar.LENGTH_SHORT).show()
                setData(layoutPosition)
            }
        }
    }
}