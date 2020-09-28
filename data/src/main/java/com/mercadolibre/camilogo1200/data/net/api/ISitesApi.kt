package com.mercadolibre.camilogo1200.data.net.api

import com.mercadolibre.camilogo1200.data.net.dto.CategoriesDTO
import com.mercadolibre.camilogo1200.data.net.dto.SiteDTO
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Defines the methods available from mercado libre sites api
 *
 * @author Cristhian C. Gómez N
 * @see <a href="https://developers.mercadolibre.com.co/es_co/categorias-y-publicaciones#close">Mercadolibre Developers Sites Api</a>
 * @see GET
 * @see Observable
 * @see Dispatchers
 * @see CategoriesDTO
 * @see SiteDTO
 * @since 1.0
 */
interface ISitesApi {
    /**
     * Gets the List of sites provided by the endpoint
     *
     * @return Observable list of Sites {@link SiteDTO}
     * @see Observable
     * @see GET
     */
    @GET(".")
    suspend fun getAllSites(): List<SiteDTO>

    /**
     * Gets the List of categories provided by the endpoint within a mercadolibre site {@link SiteDTO}
     *
     * @param site the mercadolibre site id {@link SiteDTO#getId()}
     * @return Observable list of Categories {@link CategoriesDTO}
     * @see Observable
     * @see GET
     * @see Path
     * @see SiteDTO
     * @see CategoriesDTO
     */
    @GET("/{site}/categories")
    suspend fun getSiteCategories(@Path("site") site: String): List<CategoriesDTO>
}
