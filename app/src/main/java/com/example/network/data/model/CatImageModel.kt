package com.example.network.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatImageModel(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("original_filename")
    val originalFilename: String? = null,
    @SerialName("sub_id")
    val subId: String? = null,
    val breeds: List<Breed>? = null
)

@Serializable
data class Breed(
    val id: String,
    val name: String,
    val temperament: String? = null,
    val description: String? = null,
    val origin: String? = null,
    @SerialName("life_span")
    val lifeSpan: String? = null,
    @SerialName("wikipedia_url")
    val wikipediaUrl: String? = null,
    val weight: Weight? = null
)

@Serializable
data class Weight(
    val imperial: String? = null,
    val metric: String? = null
)