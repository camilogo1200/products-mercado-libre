package com.mercadolibre.camilogo1200.products.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mercadolibre.camilogo1200.products.application.ProductsApplication
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(
    var application: ProductsApplication
) : ViewModelProvider.NewInstanceFactory() {

    private val getSitesUseCase by lazy { application.interactorsComponent.providesGetSitesUseCase() }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass)
        {
            when {
                isAssignableFrom(SitesViewModel::class.java) -> SitesViewModel(getSitesUseCase)
                else -> throw IllegalStateException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}