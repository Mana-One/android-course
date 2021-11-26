package com.manaois.app

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.manaois.app.data.ProductDatasource
import com.manaois.app.model.Product
import com.squareup.picasso.Picasso

class ProductFragment() : Fragment() {
    companion object {
        fun newInstance(product: Product): ProductFragment {
            val fragment = ProductFragment()
            val args = bundleOf("product" to product)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_product,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val product = (parentFragment?.parentFragment as DetailsFragment).product
        displayProduct(view, product)
    }

    private fun displayProduct(view: View, product: Product) {
        setProductImage(view, product)
        setProductTitle(view, product)
        setProductBrand(view, product)
        setNutriScore(view, product)
        setProductBarcode(view, product)
        setProductQuantity(view, product)
        setProductCountries(view, product)
        setProductIngredients(view, product)
        setProductAllergens(view, product)
        setProductAdditives(view, product)
    }

    private fun TextView.setTextToBold(text: String, separator: String = ":") {
        val spannable = SpannableStringBuilder(text)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        this.text = spannable
    }

    private fun setProductImage(view: View, product: Product) {
        val imgView: ImageView = view.findViewById(R.id.product_img)
        Picasso.get().load(product.imageUrl).into(imgView)
    }

    private fun setProductTitle(view: View,product: Product) {
        val spannable = SpannableStringBuilder(product.name)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, product.name.length, 0)
        val titleView: TextView = view.findViewById(R.id.product_title)
        titleView.text = spannable
    }

    private fun setProductBrand(view: View, product: Product) {
        val spannable = SpannableStringBuilder(product.brand)
        spannable.setSpan(StyleSpan(Typeface.ITALIC), 0, product.brand.length, 0)
        val brandView: TextView = view.findViewById(R.id.product_brand)
        brandView.text = spannable
    }

    private fun setProductBarcode(view: View, product: Product) {
        val barcodeView: TextView = view.findViewById(R.id.barcode_text)
        barcodeView.setTextToBold(
            getString(R.string.barcode, product.code)
        )
    }

    private fun setProductQuantity(view: View, product: Product) {
        val quantityView: TextView = view.findViewById(R.id.quantity_text)
        quantityView.setTextToBold(
            getString(R.string.quantity, product.quantity)
        )
    }

    private fun setProductCountries(view: View, product: Product) {
        val countriesView: TextView = view.findViewById(R.id.countries_text)
        countriesView.setTextToBold(
            getString(R.string.countries, product.countries.joinToString())
        )
    }

    private fun setProductIngredients(view: View, product: Product) {
        val ingredientsView: TextView = view.findViewById(R.id.ingredients_text)
        ingredientsView.setTextToBold(
            getString(R.string.ingredients, product.ingredients.joinToString())
        )
    }

    private fun setProductAllergens(view: View, product: Product) {
        val allergensView: TextView = view.findViewById(R.id.allergens_text)
        allergensView.setTextToBold(
            getString(R.string.allergens, stringListToStringOrNone(product.allergens))
        )
    }

    private fun setProductAdditives(view: View, product: Product) {
        val additivesView: TextView = view.findViewById(R.id.additives_text)
        additivesView.setTextToBold(
            getString(R.string.additives, stringListToStringOrNone(product.additives))
        )
    }

    private fun setNutriScore(view: View, product: Product) {
        val img = when (product.score) {
            'A' -> this.requireContext().getDrawable(R.drawable.nutriscore_a)
            'B' -> this.requireContext().getDrawable(R.drawable.nutriscore_b)
            'C' -> this.requireContext().getDrawable(R.drawable.nutriscore_c)
            'D' -> this.requireContext().getDrawable(R.drawable.nutriscore_d)
            else -> this.requireContext().getDrawable(R.drawable.nutriscore_e)
        }
        val imgView = view.findViewById<ImageView>(R.id.product_score)
        imgView.setImageDrawable(img)
    }

    private fun stringListToStringOrNone(values: List<String>): String {
        if (values.isEmpty()) {
            return getString(R.string.none)
        }
        return values.joinToString()
    }
}