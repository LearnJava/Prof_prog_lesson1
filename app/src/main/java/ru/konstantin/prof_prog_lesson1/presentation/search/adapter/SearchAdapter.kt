package ru.konstantin.prof_prog_lesson1.presentation.search.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.konstantin.prof_prog_lesson1.databinding.FragmentSearchListItemBinding
import ru.konstantin.prof_prog_lesson1.domain.model.DataModel

class SearchAdapter(
    private var data: List<DataModel> = emptyList())
    : RecyclerView.Adapter<SearchViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<DataModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder =
        SearchViewHolder(
            FragmentSearchListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}