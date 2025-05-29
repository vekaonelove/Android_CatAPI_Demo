package com.example.network.data.network

import com.example.network.data.model.CatImageModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

// NEVER DO IT IN PROD
private const val API_KEY = "your_api_key_here"

interface CatApiService {
    suspend fun getRandomCats(): List<CatImageModel>
}