package com.mercadolibre.camilogo1200.data.persistence.source.sites.remote

import android.graphics.drawable.Drawable
import com.mercadolibre.camilogo1200.data.di.IoDispatcher
import com.mercadolibre.camilogo1200.data.mapper.SiteMapper
import com.mercadolibre.camilogo1200.data.model.Site
import com.mercadolibre.camilogo1200.data.net.api.ISitesApi
import com.mercadolibre.camilogo1200.data.persistence.source.sites.SitesDataSource
import com.mercadolibre.camilogo1200.utils.Result
import com.mercadolibre.camilogo1200.utils.Result.Failure
import com.mercadolibre.camilogo1200.utils.Result.Success
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SiteRemoteDataSource @Inject constructor(
    private val siteApiService: ISitesApi,
    private val sitesMapper: SiteMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : SitesDataSource {
    override suspend fun getSites(reload: Boolean): Result<List<Site>> =
        withContext(ioDispatcher) {
            return@withContext try {
                Success(
                    siteApiService.getAllSites()
                        .map { siteDTO -> sitesMapper.transform(siteDTO) }
                )
            } catch (ex: Exception) {
                Failure(ex)
            }
        }

    override fun getCountryflagBySiteId(siteId: String): Single<Drawable> {
        return Single.create {
            it.onSuccess(null)
        }
    }
}
