package com.mercadolibre.camilogo1200.products.ui.viewmodels

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.*
import com.mercadolibre.camilogo1200.data.model.Site
import com.mercadolibre.camilogo1200.domain.usecases.interfaces.IGetSitesInteractor
import com.mercadolibre.camilogo1200.products.R
import kotlinx.coroutines.launch
import org.jetbrains.annotations.NotNull
import javax.inject.Inject

class SitesViewModel @Inject constructor(
    private val getSitesInteractor: IGetSitesInteractor
) : ViewModel() {

    private val _noSitesLabel = MutableLiveData<Int>()
    val noSitesLabel: LiveData<Int> = _noSitesLabel

    private val _noSitesIconRes = MutableLiveData<Int>()
    val noSitesIconRes: LiveData<Int> = _noSitesIconRes

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _items = MutableLiveData<List<Site>>().apply { value = emptyList() }
    val items: LiveData<List<Site>> = _items

    private val _snackbarText = MutableLiveData<Int>()
    val snackbarText: LiveData<Int> = _snackbarText

    private val _snackbarVisibility = MutableLiveData<Boolean?>()
    val snackbarVisibility: LiveData<Boolean?> = _snackbarVisibility

    val empty: LiveData<Boolean> = Transformations.map(_items) {
        it?.isEmpty()
    }

    init {
        setUpTexts(R.string.no_sites_label, R.drawable.ic_logo_mercado_libre_bw)
        loadSites(true)
    }

    private fun setUpTexts(
        @StringRes @NotNull noSitesLabel: Int,
        @DrawableRes @NotNull noSitesImage: Int
    ) {
        _noSitesIconRes.value = noSitesImage
        _noSitesLabel.value = noSitesLabel
    }

    private fun loadSites(forceLoad: Boolean) {
        _dataLoading.value = true
        viewModelScope.launch {
            _items.value = getSitesInteractor.execute(forceLoad)
            _dataLoading.value = false
        }
    }

    private fun showSnackbarMessage(@StringRes @NotNull message: Int, isVisible: Boolean) {
        _snackbarText.value = message
        _snackbarVisibility.value = isVisible
    }

    fun refresh() {
        loadSites(true)
    }

}