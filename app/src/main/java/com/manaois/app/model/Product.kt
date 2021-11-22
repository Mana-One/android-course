package com.manaois.app.model

import java.io.Serializable

data class Product(
    val name: String,
    val brand: String,
    val code: Long,
    val score: Char,
    val imageUrl: String,
    val quantity: String,
    val countries: List<String>,
    val ingredients: List<String>,
    val allergens: List<String>,
    val additives: List<String>
): Serializable