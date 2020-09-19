package com.mercadolibre.camilogo1200.data.net.services.interfaces

import androidx.annotation.NonNull

/**
 *
 * Defines the base methods available to all services declarations
 * <p>
 * <li> This interface  declares the {@link IServiceBase#getApi}
 * which is intended to return the raw api service
 *
 * @author Cristhian C. Gómez N
 * @see IServiceBase#getApi
 * @since 1.0
 */
interface IServiceBase<T> {
    /**
     *  Gets the retrofit raw service
     *  <p>
     *  @return the {@link Retrofit} raw api
     */
    @NonNull
    fun getApi(): T
}