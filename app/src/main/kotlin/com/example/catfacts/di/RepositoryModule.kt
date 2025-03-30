package com.example.catfacts.di

import com.example.catfacts.data.repository.CatFactsRepositoryImpl
import com.example.catfacts.domain.repository.CatFactsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindCatFactsRepository(
        impl: CatFactsRepositoryImpl
    ): CatFactsRepository
}