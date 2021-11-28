package com.manaois.app.data

import com.manaois.app.model.NutritionFacts
import com.manaois.app.model.NutritionFactsItem

class NutritionFactsDatasource() {
    private val data = NutritionFacts(
        energy = NutritionFactsItem("kj", 293.0, 0.0),
        fats = NutritionFactsItem("g", 0.8, 0.0),
        saturatedFats = NutritionFactsItem("g", 0.1, 0.0),
        carbohydrates = NutritionFactsItem("g", 8.4, 0.0),
        sugars = NutritionFactsItem("g", 5.2, 0.0),
        dietaryFibers = NutritionFactsItem("g", 5.2, 0.0),
        proteins = NutritionFactsItem("g", 4.8, 0.0),
        salt = NutritionFactsItem("g", 0.75, 0.0),
        sodium = NutritionFactsItem("g", 0.295, 0.0)
    )

    fun loadNutritionFacts(): NutritionFacts = data
}