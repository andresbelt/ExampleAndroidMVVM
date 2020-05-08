package com.examgorilla.di

import com.examgorilla.ui.component.DetailsActivity
import com.examgorilla.ui.component.SplashActivity
import com.examgorilla.ui.component.main.RecipesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModuleBuilder {

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): RecipesActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailsActivity(): DetailsActivity
}
