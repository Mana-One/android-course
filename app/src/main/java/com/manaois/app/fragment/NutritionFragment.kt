package com.manaois.app.fragment

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import com.manaois.app.R
import com.manaois.app.model.NutritionFacts
import com.manaois.app.model.NutritionalValue

class NutritionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_nutrition,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.nutrition_header_text)
            .text = getString(R.string.nutrition_header)

        val nutritionFacts = (parentFragment?.parentFragment as DetailsFragment)
            .product
            .nutritionFacts

        displayFatsNutritionFacts(view, nutritionFacts)
        displaySaturatedFatsNutritionFacts(view, nutritionFacts)
        displaySugarsNutritionFacts(view, nutritionFacts)
        displaySaltNutritionFacts(view, nutritionFacts)
    }

    private fun View.setCircleColor(nutritionalValue: NutritionalValue) {
        when(nutritionalValue) {
            NutritionalValue.LOW -> DrawableCompat.setTintList(
                this.background,
                ColorStateList.valueOf(resources.getColor(R.color.nutrient_level_low))
            )
            NutritionalValue.MODERATE -> DrawableCompat.setTintList(
                this.background,
                ColorStateList.valueOf(resources.getColor(R.color.nutrient_level_moderate))
            )
            else -> DrawableCompat.setTintList(
                this.background,
                ColorStateList.valueOf(resources.getColor(R.color.nutrient_level_high))
            )
        }
    }

    private fun TextView.setNutritionLevelText(nutritionalValue: NutritionalValue) {
        when(nutritionalValue) {
            NutritionalValue.LOW -> this.text = getString(R.string.low_nutrition_level)
            NutritionalValue.MODERATE -> this.text = getString(R.string.moderate_nutrition_level)
            else -> this.text = getString(R.string.high_nutrition_level)
        }
    }

    private fun displayFatsNutritionFacts(view: View, nutritionFacts: NutritionFacts) {
        val fats = nutritionFacts.fats
        val nutritionalValue = nutritionFacts.fatsNutritionalValue()

        val circle = view.findViewById<View>(R.id.fats_circle)
        circle.setCircleColor(nutritionalValue)

        view.findViewById<TextView>(R.id.fats_text).text = getString(
            R.string.fats,
            fats.quantityPer100g,
            fats.unit
        )

        view.findViewById<TextView>(R.id.fats_nutrition_text)
            .setNutritionLevelText(nutritionalValue)
    }

    private fun displaySaturatedFatsNutritionFacts(view: View, nutritionFacts: NutritionFacts) {
        val saturatedFats = nutritionFacts.saturatedFats
        val nutritionalValue = nutritionFacts.saturatedFatsNutritionalValue()

        val circle = view.findViewById<View>(R.id.saturated_fats_circle)
        circle.setCircleColor(nutritionalValue)

        view.findViewById<TextView>(R.id.saturated_fats_text).text = getString(
            R.string.saturated_fats,
            saturatedFats.quantityPer100g,
            saturatedFats.unit
        )

        view.findViewById<TextView>(R.id.saturated_fats_nutrition_text)
            .setNutritionLevelText(nutritionalValue)
    }

    private fun displaySugarsNutritionFacts(view: View, nutritionFacts: NutritionFacts) {
        val sugars = nutritionFacts.sugars
        val nutritionalValue = nutritionFacts.sugarsNutritionalValue()

        val circle = view.findViewById<View>(R.id.sugars_circle)
        circle.setCircleColor(nutritionalValue)

        view.findViewById<TextView>(R.id.sugars_text).text = getString(
            R.string.sugars,
            sugars.quantityPer100g,
            sugars.unit
        )

        view.findViewById<TextView>(R.id.sugars_nutrition_text)
            .setNutritionLevelText(nutritionalValue)
    }

    private fun displaySaltNutritionFacts(view: View, nutritionFacts: NutritionFacts) {
        val salt = nutritionFacts.salt
        val nutritionalValue = nutritionFacts.saltNutritionalValue()

        val circle = view.findViewById<View>(R.id.salt_circle)
        circle.setCircleColor(nutritionalValue)

        view.findViewById<TextView>(R.id.salt_text).text = getString(
            R.string.salt,
            salt.quantityPer100g,
            salt.unit
        )

        view.findViewById<TextView>(R.id.salt_nutrition_text)
            .setNutritionLevelText(nutritionalValue)
    }
}