package com.example.catfacts.data.repository

import com.example.catfacts.data.mapper.toFact
import com.example.catfacts.data.remote.CatFactsApi
import com.example.catfacts.domain.model.Fact
import com.example.catfacts.domain.repository.CatFactsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatFactsRepositoryImpl @Inject constructor(
    private val api: CatFactsApi
) : CatFactsRepository {
    override fun getFacts(): Flow<List<Fact>> = flow {
        val facts = api.getFacts().map { it.toFact() }
        emit(facts)
    }
}