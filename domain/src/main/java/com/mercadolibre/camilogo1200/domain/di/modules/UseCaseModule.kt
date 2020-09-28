package com.mercadolibre.camilogo1200.domain.di.modules

import com.mercadolibre.camilogo1200.data.di.IoDispatcher
import com.mercadolibre.camilogo1200.domain.repository.ISiteRepository
import com.mercadolibre.camilogo1200.domain.usecases.GetSitesUseCase
import com.mercadolibre.camilogo1200.domain.usecases.interfaces.IGetSitesInteractor
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

/**
 * Dagger Module that provides a singleton Use Cases / Interactors for injection
 *
 * @see CoroutineDispatcher
 * @see ISiteRepository
 * @see IGetSitesInteractor
 * @since 1.0.0
 * @author Cristhian C. Gómez N
 */
@Module
class UseCaseModule {

    @Provides
    @Singleton
    internal fun provideGetSiteUseCase(
        siteRepository: ISiteRepository,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): IGetSitesInteractor {
        return GetSitesUseCase(siteRepository, ioDispatcher)
    }
}