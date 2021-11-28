package com.manaois.app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.manaois.app.R
import com.manaois.app.model.Product
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {

    companion object {
        const val PRODUCT = "product"
    }

    private lateinit var _product: Product
    val product get() = _product!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _product = it.getSerializable(PRODUCT) as Product
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(
            R.layout.fragment_details,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("\n\nReceived Product ${product.name}\n")
        val navHost = childFragmentManager
            .findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(product_details_bottom_nav, navHost.navController)
    }
}