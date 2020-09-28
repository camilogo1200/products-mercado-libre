package com.mercadolibre.camilogo1200.domain.di.modules

import com.mercadolibre.camilogo1200.data.di.providers.NetworkChecker
import com.mercadolibre.camilogo1200.data.persistence.source.sites.local.SiteLocalDataSource
import com.mercadolibre.camilogo1200.data.persistence.source.sites.remote.SiteRemoteDataSource
import com.mercadolibre.camilogo1200.domain.repository.ISiteRepository
import com.mercadolibre.camilogo1200.domain.repository.SiteDataRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * DaggerModule that provides a singleton Site Repository
 *
 * Thanks to mikhael lopez for provide the Network Checker implementation
 *
 * @since 1.0.0
 *@author Cristhian C. Gómez N
 */
@Module
class SiteRepositoryModule {

    @Provides
    @Singleton
    internal fun provideSiteDataRepository(
        siteRemoteDataSource: SiteRemoteDataSource,
        siteLocalDataSource: SiteLocalDataSource,
        networkChecker: NetworkChecker
    ): ISiteRepository {
        return SiteDataRepository(siteRemoteDataSource, siteLocalDataSource, networkChecker)
    }
}