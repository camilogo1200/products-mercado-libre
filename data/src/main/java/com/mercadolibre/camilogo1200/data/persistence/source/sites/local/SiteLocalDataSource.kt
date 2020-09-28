package com.mercadolibre.camilogo1200.data.persistence.source.sites.local

import android.graphics.drawable.Drawable
import com.mercadolibre.camilogo1200.data.di.IoDispatcher
import com.mercadolibre.camilogo1200.data.mapper.SiteMapper
import com.mercadolibre.camilogo1200.data.model.Site
import com.mercadolibre.camilogo1200.data.persistence.dao.SiteDao
import com.mercadolibre.camilogo1200.data.persistence.source.sites.SitesDataSource
import com.mercadolibre.camilogo1200.utils.Result
import com.mercadolibre.camilogo1200.utils.Result.Failure
import com.mercadolibre.camilogo1200.utils.Result.Success
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SiteLocalDataSource
@Inject internal constructor(
    private val siteDao: SiteDao,
    private val siteMapper: SiteMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : SitesDataSource {
    val countryFlags: Map<String, Drawable> = emptyMap()
    override suspend fun getSites(reload: Boolean): Result<List<Site>> =
        withContext(ioDispatcher) {
            return@withContext try {
                Success(
                    siteDao.getAllSites()
                        .map { site -> siteMapper.transform(site) }
                )
            } catch (ex: Exception) {
                Failure(ex)
            }
        }

    override fun getCountryflagBySiteId(siteId: String): Single<Drawable> {
        return Single.create { emitter ->
            emitter.onSuccess(countryFlags.asSequence()
                .filter { pair -> pair.key == siteId }
                .firstOrNull()?.value)
        }
    }

    init {
        loadCountryFlags()
    }

    private fun loadCountryFlags() {

    }

}