package com.manaois.app.model

import java.io.Serializable

data class NutritionFactsItem(
    val unit: String,
    val quantityPer100g: Double,
    val quantityPerPortion: Double
) : Serializable