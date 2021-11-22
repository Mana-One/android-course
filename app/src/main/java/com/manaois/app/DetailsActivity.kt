package com.manaois.app

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.manaois.app.model.Product
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val PRODUCT = "product"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val product = intent?.extras?.getSerializable(PRODUCT) as? Product
        if (product != null)
        {
            displayProduct(product)
        }
    }

    private fun displayProduct(product: Product) {
        setProductImage(product)
        setProductTitle(product)
        setProductBrand(product)
        setNutriScore(product)
        setProductBarcode(product)
        setProductQuantity(product)
        setProductCountries(product)
        setProductIngredients(product)
        setProductAllergens(product)
        setProductAdditives(product)
    }

    private fun TextView.setTextToBold(text: String, separator: String = ":") {
        val spannable = SpannableStringBuilder(text)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        this.text = spannable
    }

    private fun setProductImage(product: Product) {
        val imgView: ImageView = findViewById(R.id.product_img)
        Picasso.get().load(product.imageUrl).into(imgView)
    }

    private fun setProductTitle(product: Product) {
        val spannable = SpannableStringBuilder(product.name)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, product.name.length, 0)
        val titleView: TextView = findViewById(R.id.product_title)
        titleView.text = spannable
    }

    private fun setProductBrand(product: Product) {
        val spannable = SpannableStringBuilder(product.brand)
        spannable.setSpan(StyleSpan(Typeface.ITALIC), 0, product.brand.length, 0)
        val brandView: TextView = findViewById(R.id.product_brand)
        brandView.text = spannable
    }

    private fun setProductBarcode(product: Product) {
        val barcodeView: TextView = findViewById(R.id.barcode_text)
        barcodeView.setTextToBold(
            getString(R.string.barcode, product.code)
        )
    }

    private fun setProductQuantity(product: Product) {
        val quantityView: TextView = findViewById(R.id.quantity_text)
        quantityView.setTextToBold(
            getString(R.string.quantity, product.quantity)
        )
    }

    private fun setProductCountries(product: Product) {
        val countriesView: TextView = findViewById(R.id.countries_text)
        countriesView.setTextToBold(
            getString(R.string.countries, product.countries.joinToString())
        )
    }

    private fun setProductIngredients(product: Product) {
        val ingredientsView: TextView = findViewById(R.id.ingredients_text)
        ingredientsView.setTextToBold(
            getString(R.string.ingredients, product.ingredients.joinToString())
        )
    }

    private fun setProductAllergens(product: Product) {
        val allergensView: TextView = findViewById(R.id.allergens_text)
        allergensView.setTextToBold(
            getString(R.string.allergens, stringListToStringOrNone(product.allergens))
        )
    }

    private fun setProductAdditives(product: Product) {
        val additivesView: TextView = findViewById(R.id.additives_text)
        additivesView.setTextToBold(
            getString(R.string.additives, stringListToStringOrNone(product.additives))
        )
    }

    private fun setNutriScore(product: Product) {
        val img = when (product.score) {
            'A' -> getDrawable(R.drawable.nutriscore_a)
            'B' -> getDrawable(R.drawable.nutriscore_b)
            'C' -> getDrawable(R.drawable.nutriscore_c)
            'D' -> getDrawable(R.drawable.nutriscore_d)
            else -> getDrawable(R.drawable.nutriscore_e)
        }
        val imgView = findViewById<ImageView>(R.id.product_score)
        imgView.setImageDrawable(img)
    }

    private fun stringListToStringOrNone(values: List<String>): String {
        if (values.isEmpty()) {
            return getString(R.string.none)
        }
        return values.joinToString()
    }
}