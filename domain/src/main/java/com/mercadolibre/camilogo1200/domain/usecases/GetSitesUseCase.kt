package com.mercadolibre.camilogo1200.domain.usecases

import com.mercadolibre.camilogo1200.data.di.IoDispatcher
import com.mercadolibre.camilogo1200.data.model.Site
import com.mercadolibre.camilogo1200.domain.repository.ISiteRepository
import com.mercadolibre.camilogo1200.domain.usecases.interfaces.IGetSitesInteractor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetSitesUseCase @Inject constructor(
    private val sitesRepositories: ISiteRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IGetSitesInteractor {
    override suspend fun execute(forceReload: Boolean): List<Site> =
        withContext(ioDispatcher) {
            sitesRepositories.getSites(forceReload)
        }
}