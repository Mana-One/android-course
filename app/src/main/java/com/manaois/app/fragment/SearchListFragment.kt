package com.manaois.app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.manaois.app.R
import com.manaois.app.adapter.ProductAdapter
import com.manaois.app.data.ProductDatasource

class SearchListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.search_list_view)
        recyclerView.adapter = ProductAdapter(
            this.requireContext(),
            ProductDatasource().loadProducts()
        )
        recyclerView.setHasFixedSize(true)
    }
}