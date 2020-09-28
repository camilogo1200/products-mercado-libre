package com.mercadolibre.camilogo1200.products.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mercadolibre.camilogo1200.products.ui.activity.MainActivity

abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as MainActivity).supportActionBar?.show()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun getContext(): Context = requireContext()
}