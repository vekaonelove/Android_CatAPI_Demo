package com.example.network.data.network

import com.example.network.data.model.CatImageModel
import com.example.catapi.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

// NEVER DO IT IN PROD
private const val API_KEY = BuildConfig.API_KEY

interface CatApiService {
    @GET("v1/images/search")
    suspend fun getRandomCats(
        @Query("limit") limit: Int = 10,
        @Query("size") size: String = "med",
        @Query("has_breeds") hasBreeds: Int = 1,
        @Query("order") order: String = "RANDOM",
        @Header("x-api-key") apiKey: String = API_KEY
    ): List<CatImageModel>
    
    @GET("v1/images/search")
    suspend fun getCatsByBreed(
        @Query("breed_ids") breedId: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0,
        @Header("x-api-key") apiKey: String = API_KEY
    ): List<CatImageModel>
}