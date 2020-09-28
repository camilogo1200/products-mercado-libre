package com.mercadolibre.camilogo1200.domain.repository

import com.mercadolibre.camilogo1200.data.model.Site

interface ISiteRepository {
    suspend fun getSites(reload: Boolean): List<Site>
}
