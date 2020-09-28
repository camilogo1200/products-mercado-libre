package com.mercadolibre.camilogo1200.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mercadolibre.camilogo1200.data.di.IoDispatcher
import com.mercadolibre.camilogo1200.data.di.providers.NetworkChecker
import com.mercadolibre.camilogo1200.data.model.Site
import com.mercadolibre.camilogo1200.data.persistence.source.sites.SitesDataSource
import com.mercadolibre.camilogo1200.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

data class SiteDataRepository(
    private val siteRemoteDataSource: SitesDataSource,
    private val siteLocalDataSource: SitesDataSource,
    private val networkChecker: NetworkChecker,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ISiteRepository {
    private val _myLiveData = MutableLiveData<List<Site>>()
    val myLiveData: LiveData<List<Site>>
        get() = _myLiveData

    override suspend fun getSites(reload: Boolean): List<Site> {
        Timber.d("getSites - networkChecker.isConnected is ${networkChecker.isConnected}")
        return withContext(ioDispatcher) {
            when (networkChecker.isConnected) {
                true -> getRemoteData(reload)
                else -> getCachedData()
            }
        }
    }

    private suspend fun getRemoteData(reload: Boolean): List<Site> {
        Timber.i("getRemoteData")
        return when (val list = siteRemoteDataSource.getSites()) {
            is Result.Failure -> {
                Timber.w("Get Sites from remote data source failed.")
                listOf()
            }
            is Result.Success -> {
                Timber.d("Remote Data size => ${list.data.size}")
                list.data
            }
            else -> throw IllegalStateException()
        }
    }

    private suspend fun getCachedData(): List<Site> {
        return when (val list = siteLocalDataSource.getSites()) {
            is Result.Failure -> {
                Timber.w("Get Sites from local data source failed.")
                listOf()
            }
            is Result.Success -> {
                Timber.d("Cached Data size => ${list.data.size}")
                list.data
            }
            else -> throw IllegalStateException()
        }
    }
}
