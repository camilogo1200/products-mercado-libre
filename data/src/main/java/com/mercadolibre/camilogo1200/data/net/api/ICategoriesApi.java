package com.mercadolibre.camilogo1200.data.net.api;

import com.mercadolibre.camilogo1200.data.net.dto.CategoriesDTO;
import com.mercadolibre.camilogo1200.data.net.dto.SiteDTO;

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
 * @see SiteDTO
 * @since 1.0
 */
public interface ICategoriesApi {
    @GET("/{categoryId}")
    Observable<CategoriesDTO> getCategoryInfoByCategoryId(@Path("categoryId") String categoryId);
}
