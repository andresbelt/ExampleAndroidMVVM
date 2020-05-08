package com.examgorilla.di

import com.examgorilla.bussinesLogic.errors.ErrorFactory
import com.examgorilla.bussinesLogic.errors.ErrorManager
import com.examgorilla.data.errors.ErrorMapper
import com.examgorilla.data.errors.ErrorMapperInterface
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ErrorModule {
    @Binds
    @Singleton
    abstract fun provideErrorFactoryImpl(errorManager: ErrorManager): ErrorFactory

    @Binds
    @Singleton
    abstract fun provideErrorMapper(errorMapper: ErrorMapper): ErrorMapperInterface
}
