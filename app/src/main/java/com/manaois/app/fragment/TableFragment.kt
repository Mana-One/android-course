package com.manaois.app.fragment

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.manaois.app.R
import com.manaois.app.model.NutritionFacts
import com.manaois.app.model.NutritionFactsItem
import com.manaois.app.view.TableCellView

class TableFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_table,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nutritionFacts = (parentFragment?.parentFragment as DetailsFragment)
            .product
            .nutritionFacts

        displayHeaderRow(view)
        displayEnergyRow(view, nutritionFacts.energy)
        displayFatsRow(view, nutritionFacts.fats)
        displaySaturatedFatsRow(view, nutritionFacts.saturatedFats)
        displayCarbohydratesRow(view, nutritionFacts.carbohydrates)
        displaySugarsRow(view, nutritionFacts.sugars)
        displayFibersRow(view, nutritionFacts.dietaryFibers)
        displayProteinsRow(view, nutritionFacts.proteins)
        displaySaltRow(view, nutritionFacts.salt)
        displaySodiumRow(view, nutritionFacts.sodium)
    }

    private fun TableCellView.setBoldText(text: String) {
        val spannable = SpannableStringBuilder(text)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, text.length, 0)
        this.text = spannable
    }

    private fun displayHeaderRow(view: View) {
        val row: LinearLayout = view.findViewById(R.id.header_row)
        row.findViewById<TableCellView>(R.id.left_cell).text = ""
        row.findViewById<TableCellView>(R.id.middle_cell)
            .setBoldText(getString(R.string.hundred_col_header))
        row.findViewById<TableCellView>(R.id.right_cell)
            .setBoldText(getString(R.string.portion_col_header))
    }

    private fun displayEnergyRow(view: View, nutritionFactsItem: NutritionFactsItem) {
        displayRegularRow(
            view.findViewById(R.id.energy_row),
            getString(R.string.energy_row_header),
            nutritionFactsItem
        )
    }

    private fun displayFatsRow(view: View, nutritionFactsItem: NutritionFactsItem) {
        displayRegularRow(
            view.findViewById(R.id.fats_row),
            getString(R.string.fats_row_header),
            nutritionFactsItem
        )
    }

    private fun displaySaturatedFatsRow(view: View, nutritionFactsItem: NutritionFactsItem) {
        displayRegularRow(
            view.findViewById(R.id.saturated_fats_row),
            getString(R.string.saturated_fats_row_header),
            nutritionFactsItem
        )
    }

    private fun displayCarbohydratesRow(view: View, nutritionFactsItem: NutritionFactsItem) {
        displayRegularRow(
            view.findViewById(R.id.carbohydrates_row),
            getString(R.string.carbohydrates_row_header),
            nutritionFactsItem
        )
    }

    private fun displaySugarsRow(view: View, nutritionFactsItem: NutritionFactsItem) {
        displayRegularRow(
            view.findViewById(R.id.sugars_row),
            getString(R.string.sugars_row_header),
            nutritionFactsItem
        )
    }

    private fun displayFibersRow(view: View, nutritionFactsItem: NutritionFactsItem) {
        displayRegularRow(
            view.findViewById(R.id.fibers_row),
            getString(R.string.fibers_row_header),
            nutritionFactsItem
        )
    }

    private fun displayProteinsRow(view: View, nutritionFactsItem: NutritionFactsItem) {
        displayRegularRow(
            view.findViewById(R.id.proteins_row),
            getString(R.string.proteins_row_header),
            nutritionFactsItem
        )
    }

    private fun displaySaltRow(view: View, nutritionFactsItem: NutritionFactsItem) {
        displayRegularRow(
            view.findViewById(R.id.salt_row),
            getString(R.string.salt_row_header),
            nutritionFactsItem
        )
    }

    private fun displaySodiumRow(view: View, nutritionFactsItem: NutritionFactsItem) {
        displayRegularRow(
            view.findViewById(R.id.sodium_row),
            getString(R.string.sodium_row_header),
            nutritionFactsItem
        )
    }

    private fun displayRegularRow(
        row: LinearLayout,
        leftText: String,
        nutritionFactsItem: NutritionFactsItem
    ) {
        row.findViewById<TableCellView>(R.id.left_cell)
            .setBoldText(leftText)
        row.findViewById<TableCellView>(R.id.middle_cell)
            .text = nutritionFactsItem.hundredGramString()
        row.findViewById<TableCellView>(R.id.right_cell).text = "?"
    }
}