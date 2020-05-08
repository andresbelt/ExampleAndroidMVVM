package com.examgorilla.ui.component.main

import androidx.recyclerview.widget.RecyclerView
import com.examgorilla.data.dto.RecipeItem
import com.examgorilla.databinding.RecipesitemBinding

class ReceipeViewHolder(private val itemBinding: RecipesitemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(newsItem: RecipeItem, recyclerItemListener: RecyclerItemListener) {
        itemBinding.title.text = newsItem.title

        itemBinding.rlNewsItem.setOnClickListener { recyclerItemListener.onItemSelected(newsItem) }
    }
}
