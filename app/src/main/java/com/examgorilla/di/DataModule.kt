package com.examgorilla.di

import com.examgorilla.data.DataRepository
import com.examgorilla.data.server.Source
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideDataRepository(dataRepository: DataRepository): Source
}
