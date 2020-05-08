package com.examgorilla.ui.component

import android.os.Bundle
import androidx.lifecycle.LiveData
import com.examgorilla.data.Resource
import com.examgorilla.data.dto.RecipeDetailItem
import com.examgorilla.databinding.DetailsactivityBinding
import com.examgorilla.ui.ViewModelFactory
import com.examgorilla.util.Constants
import com.examgorilla.util.Event
import com.examgorilla.util.observe
import com.examgorilla.util.showToast
import com.google.android.material.snackbar.Snackbar
import com.task.ui.base.BaseActivity
import javax.inject.Inject


class DetailsActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: DetailsViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: DetailsactivityBinding


    override fun initViewBinding() {
        binding = DetailsactivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      val id =  intent.getStringExtra(Constants.RECIPES_ITEM_KEY)
        viewModel.getDetailRecipe(id)
    }

    override fun observeViewModel() {
        observe(viewModel.recipeDetailItemLiveData, ::handleRecipesList)
    }

    override fun initializeViewModel() {
        viewModel = viewModelFactory.create(viewModel::class.java)
    }


    private fun handleRecipesList(RecipeItem: Resource<RecipeDetailItem>) {
        when (RecipeItem) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> RecipeItem.data?.let {
                initializeView(recipeItem = it)
            }
            is Resource.DataError -> {
                showDataView(false)
                RecipeItem.errorCode?.let { viewModel.showToastMessage(it) }
            }
        }

    }


    private fun initializeView(recipeItem: RecipeDetailItem) {
//        binding.tvTitle.text = recipeItem.title
//        binding.tvDescription.text = recipeItem.title
//        if (!recipeItem.image.isNullOrEmpty()) {
//            Picasso.get().load(recipeItem.image).placeholder(R.drawable.news)
//                    .into(binding.img_url)
//        }
    }

    private fun observeToast(event: LiveData<Event<Any>>) {
        binding.rlDetails.showToast(this, event, Snackbar.LENGTH_LONG)
    }

    private fun showDataView(show: Boolean) {
//        binding.tvNoData.visibility = if (show) View.GONE else View.VISIBLE
//        binding.rlRecipesList.visibility = if (show) View.VISIBLE else View.GONE
//        binding.pbLoading.toGone()
    }

    private fun showLoadingView() {
//        binding.pbLoading.toVisible()
//        binding.tvNoData.toGone()
//        binding.rlRecipesList.toGone()
    }



}
