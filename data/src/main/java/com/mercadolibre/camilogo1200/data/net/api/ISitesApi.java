package com.mercadolibre.camilogo1200.data.net.api;

import com.mercadolibre.camilogo1200.data.net.dto.CategoriesDTO;
import com.mercadolibre.camilogo1200.data.net.dto.SitesDTO;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Defines the methods available from mercado libre sites api
 *
 * @author Cristhian C. Gómez N
 * @see <a href="https://developers.mercadolibre.com.co/es_co/categorias-y-publicaciones#close">Mercadolibre Developers Sites Api</a>
 * @see GET
 * @see Observable
 * @see CategoriesDTO
 * @see SitesDTO
 * @since 1.0
 */
public interface ISitesApi {
    /**
     * Gets the List of sites provided by the endpoint
     *
     * @return Observable list of Sites {@link SitesDTO}
     * @see Observable
     * @see GET
     */
    @GET("/")
    Observable<List<SitesDTO>> getAllSites();

    /**
     * Gets the List of categories provided by the endpoint within a mercadolibre site {@link SitesDTO}
     *
     * @param site the mercadolibre site id {@link SitesDTO#getId()}
     * @return Observable list of Categories {@link CategoriesDTO}
     * @see Observable
     * @see GET
     * @see Path
     * @see SitesDTO
     * @see CategoriesDTO
     */
    @GET("/{site}/categories")
    Observable<List<CategoriesDTO>> getSiteCategories(@Path("site") String site);
}
