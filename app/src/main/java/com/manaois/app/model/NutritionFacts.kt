package com.manaois.app.model

import java.io.Serializable

data class NutritionFacts(
    val energy: NutritionFactsItem,
    val fats: NutritionFactsItem,
    val saturatedFats: NutritionFactsItem,
    val carbohydrates: NutritionFactsItem,
    val sugars: NutritionFactsItem,
    val dietaryFibers: NutritionFactsItem,
    val proteins: NutritionFactsItem,
    val salt: NutritionFactsItem,
    val sodium: NutritionFactsItem
) : Serializable {
    fun fatsNutritionalValue(): NutritionalValue {
        val (_,quantityPer100g) = fats
        return when {
            quantityPer100g > 20.0 -> NutritionalValue.HIGH
            quantityPer100g < 3.0 -> NutritionalValue.LOW
            else -> NutritionalValue.MODERATE
        }
    }

    fun saturatedFatsNutritionalValue(): NutritionalValue {
        val (_, quantityPer100g) = saturatedFats
        return when {
            quantityPer100g > 5.0 -> NutritionalValue.HIGH
            quantityPer100g < 1.5 -> NutritionalValue.LOW
            else -> NutritionalValue.MODERATE
        }
    }

    fun sugarsNutritionalValue(): NutritionalValue {
        val (_, quantityPer100g) = sugars
        return when {
            quantityPer100g > 12.5 -> NutritionalValue.HIGH
            quantityPer100g < 5.0 -> NutritionalValue.LOW
            else -> NutritionalValue.MODERATE
        }
    }

    fun saltNutritionalValue(): NutritionalValue {
        val (_, quantityPer100g) = salt
        return when {
            quantityPer100g > 1.5 -> NutritionalValue.HIGH
            quantityPer100g < 0.3 -> NutritionalValue.LOW
            else -> NutritionalValue.MODERATE
        }
    }
}