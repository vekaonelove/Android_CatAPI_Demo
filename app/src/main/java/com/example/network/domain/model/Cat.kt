package com.example.network.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    val id: String,
    val imageUrl: String,
    val width: Int,
    val height: Int,
    val breed: Breed? = null
)

@Serializable
data class Breed(
    val id: String,
    val name: String,
    val temperament: String? = null,
    val description: String? = null,
    val origin: String? = null,
    val lifeSpan: String? = null
) 