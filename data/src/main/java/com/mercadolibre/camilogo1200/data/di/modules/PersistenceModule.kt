package com.mercadolibre.camilogo1200.data.di.modules

import android.content.Context
import com.mercadolibre.camilogo1200.data.persistence.dao.SiteDao
import com.mercadolibre.camilogo1200.data.persistence.source.AppDatabase
import com.mercadolibre.camilogo1200.data.persistence.source.DatabaseFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        DatabaseFactory.getDatabase(context)


    @Provides
    @Singleton
    internal fun provideSiteDao(appDatabase: AppDatabase): SiteDao = appDatabase.siteDao()

}