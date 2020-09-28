package com.mercadolibre.camilogo1200.data.persistence.source.sites

import android.graphics.drawable.Drawable
import com.mercadolibre.camilogo1200.data.model.Site
import com.mercadolibre.camilogo1200.utils.Result
import io.reactivex.rxjava3.core.Single

/**
 * Interface that express the available methods and decouples implementation
 * @author Cristhian C. Gómez N.
 * @since 1.0.0
 *
 */
interface SitesDataSource {
    /**
     * Gets all available sites
     *
     * @param reload used to force the cache clean and remote retrieve
     * @return [Result.Success] if the information was successfully retrieved
     * [Result.Error] if any error occurred during the information retrieval process
     * @author Cristhian C. Gómez N.
     * @since 1.0.0
     */
    suspend fun getSites(reload: Boolean = false): Result<List<Site>>
    fun getCountryflagBySiteId(siteId: String): Single<Drawable>
}