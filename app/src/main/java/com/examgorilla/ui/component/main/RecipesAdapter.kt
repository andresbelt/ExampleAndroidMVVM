package com.examgorilla.ui.component.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.examgorilla.data.dto.RecipeItem
import com.examgorilla.databinding.RecipesitemBinding
import com.examgorilla.ui.component.main.ReceipeViewHolder
import com.examgorilla.ui.component.main.RecipesListViewModel
import com.examgorilla.ui.component.main.RecyclerItemListener

class RecipesAdapter(private val newsListViewModel: RecipesListViewModel, private val receipe: List<RecipeItem>) : RecyclerView.Adapter<ReceipeViewHolder>() {

    private val onItemClickListener: RecyclerItemListener = object : RecyclerItemListener {
        override fun onItemSelected(newsItem: RecipeItem) {
            newsListViewModel.openRecipesDetails(newsItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceipeViewHolder {
        val itemBinding = RecipesitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReceipeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ReceipeViewHolder, position: Int) {
        holder.bind(receipe[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return receipe.size
    }
}

