package com.manaois.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.manaois.app.adapter.ProductAdapter
import com.manaois.app.data.ProductDatasource

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val dataset = ProductDatasource().loadProducts()
        val recyclerView = findViewById<RecyclerView>(R.id.search_list_view)
        recyclerView.adapter = ProductAdapter(this, dataset)
        recyclerView.setHasFixedSize(true)
    }
}