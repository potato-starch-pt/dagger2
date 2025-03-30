package com.example.catfacts.data.remote

interface CatFactsApi {
    suspend fun getFacts(): List<FactDto>
}