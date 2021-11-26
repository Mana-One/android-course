package com.manaois.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.manaois.app.R
import com.manaois.app.SearchListFragmentDirections
import com.manaois.app.model.Product
import com.squareup.picasso.Picasso

class ProductAdapter(
    private val context: Context,
    private val dataset: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<ImageView>(R.id.card_img)
        val titleView = view.findViewById<TextView>(R.id.card_title)
        val brandView = view.findViewById<TextView>(R.id.card_brand)
        val nutriscoreTextView = view.findViewById<TextView>(R.id.card_nutriscore_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_search_item, parent, false)
        return ProductViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = dataset[position]
        Picasso.get().load(product.imageUrl).into(holder.imageView)
        holder.titleView.text = product.name
        holder.brandView.text = product.brand
        holder.nutriscoreTextView.text = context.getString(R.string.nutriscore, product.score)

        holder.imageView.setOnClickListener {
            val action = SearchListFragmentDirections
                .actionSearchListFragmentToDetailsFragment(product = product)
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = dataset.size
}