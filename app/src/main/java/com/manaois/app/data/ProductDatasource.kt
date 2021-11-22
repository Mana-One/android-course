package com.manaois.app.data

import com.manaois.app.model.Product

class ProductDatasource {
    private val data = Product(
        name = "Petit pois et carottes",
        brand = "Cassegrain",
        code = 3083680085304,
        quantity = "400 g (280 g net égoutté)",
        countries = listOf(
            "France",
            "Japon",
            "Suisse"
        ),
        score = 'A',
        imageUrl = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
        ingredients = listOf(
            "Petits pois 66%",
            "eau",
            "garniture 2,8% (salade, oignon grelot)",
            "sucre",
            "sel",
            "arôme naturel"
        ),
        allergens = listOf(),
        additives = listOf()
    )

    fun loadProducts() : List<Product> = List(10) { data }
}