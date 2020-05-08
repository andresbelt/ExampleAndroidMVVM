package com.task.ui.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.examgorilla.databinding.ViewtoolbarBinding
import com.examgorilla.ui.base.ActionBarView
import com.examgorilla.ui.base.BaseViewModel
import dagger.android.AndroidInjection


abstract class BaseActivity : AppCompatActivity(), ActionBarView {

    protected lateinit var baseViewModel: BaseViewModel

    protected lateinit var toolbarBinding: ViewtoolbarBinding

    protected abstract fun initializeViewModel()
    abstract fun observeViewModel()
    protected abstract fun initViewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initViewBinding()
        initializeToolbar()
        initializeViewModel()
        observeViewModel()
    }

    private fun initializeToolbar() {
        toolbarBinding = ViewtoolbarBinding.inflate(layoutInflater)
    }


    override fun setTitle(titleKey: String) {
        toolbarBinding.txtToolbarTitle.text = titleKey
    }

//    override fun setSettingsIconVisibility(visibility: Boolean) {
//        toolbarBinding.icToolbarSetting.visibility = if (visibility) VISIBLE else GONE
//    }
//
//    override fun setRefreshVisibility(visibility: Boolean) {
//        toolbarBinding.icToolbarRefresh.visibility = if (visibility) VISIBLE else GONE
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
