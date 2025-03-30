package com.example.catfacts.data.remote

import com.example.catfacts.data.remote.dto.FactDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CatFactsApi {
    @GET("facts")
    suspend fun getFacts(
        @Query("limit") limit: Int = 20,
        @Query("max_length") maxLength: Int? = null
    ): List<FactDto>
}