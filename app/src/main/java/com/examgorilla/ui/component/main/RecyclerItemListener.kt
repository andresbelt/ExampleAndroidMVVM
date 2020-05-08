package com.examgorilla.ui.component.main

import com.examgorilla.data.dto.RecipeItem

interface RecyclerItemListener {
    fun onItemSelected(newsItem: RecipeItem)
}