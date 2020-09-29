package com.mercadolibre.camilogo1200.products.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mercadolibre.camilogo1200.data.model.Site
import com.mercadolibre.camilogo1200.products.R
import com.mercadolibre.camilogo1200.products.databinding.FragmentSitesListBinding
import com.mercadolibre.camilogo1200.products.ui.fragments.adapters.SitesAdapter
import com.mercadolibre.camilogo1200.products.ui.viewmodels.SitesViewModel
import com.mercadolibre.camilogo1200.products.util.getViewModelFactory
import timber.log.Timber

class SitesListFragment : BaseFragment() {

    private lateinit var _binding: FragmentSitesListBinding
    private val viewModel by viewModels<SitesViewModel> { getViewModelFactory() }

    private lateinit var listAdapter: SitesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSitesListBinding.inflate(inflater, container, false)
            .apply { viewmodel = viewModel }
        setHasOptionsMenu(false)
        listAdapter = SitesAdapter { site ->
            navigateToCategories(site)
        }
        return _binding.root
    }

    private fun navigateToCategories(site: Site) {
        val action =
            SitesListFragmentDirections.actionSitesListFragmentToCategoriesListFragment(site)
        findNavController().navigate(action)
    }

    private fun setUpSwipeRefreshLayout() {
        _binding.sitesSwipeRefresh.setColorSchemeResources(
            R.color.primary, R.color.primary_dark, R.color.accent
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        _binding.lifecycleOwner = this.viewLifecycleOwner
        setupListAdapter()
        setUpSwipeRefreshLayout()
        setUpSnackbar()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        viewModel.items.observe(viewLifecycleOwner, { data ->
            if (data != null) {
                listAdapter.setDataList(data)
            }
        })
    }

    private fun setUpSnackbar() {
        viewModel.snackbarText.observe(_binding.lifecycleOwner!!, { snackText ->
            snackText?.let {
                Snackbar.make(_binding.root, snackText, Snackbar.LENGTH_LONG)
                    .show()
            }
        })
    }

    private fun setupListAdapter() {
        val vm = _binding.viewmodel
        if (vm != null) {
            _binding.rvSiteList.adapter = listAdapter
        } else {
            Timber.w("ViewModel not initialized when attempting to set up adapter")
        }
    }


}