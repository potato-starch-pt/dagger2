package com.example.catfacts.domain.repository

import com.example.catfacts.domain.model.Fact
import kotlinx.coroutines.flow.Flow

interface CatFactsRepository {
    fun getFacts(): Flow<List<Fact>>
}