package com.mercadolibre.camilogo1200.domain.usecases.interfaces

import com.mercadolibre.camilogo1200.data.model.Site

interface IGetSitesInteractor {
    suspend fun execute(forceReload: Boolean): List<Site>
}