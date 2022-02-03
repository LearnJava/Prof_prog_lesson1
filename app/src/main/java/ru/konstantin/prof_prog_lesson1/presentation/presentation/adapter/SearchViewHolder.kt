package ru.konstantin.prof_prog_lesson1.presentation.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.translators.databinding.FragmentSearchListItemBinding
import ru.konstantin.prof_prog_lesson1.presentation.domain.model.DataModel

class SearchViewHolder(
    private val binding: FragmentSearchListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(dataModel: DataModel) {
        binding.titleTextView.text = dataModel.text
        binding.translationTextView.text = dataModel.meanings[0].translation.text
    }
}