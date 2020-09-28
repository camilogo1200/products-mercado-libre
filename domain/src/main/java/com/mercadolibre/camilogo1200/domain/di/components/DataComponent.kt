package com.mercadolibre.camilogo1200.domain.di.components

import android.content.Context
import com.mercadolibre.camilogo1200.data.di.modules.DispatchersModule
import com.mercadolibre.camilogo1200.data.di.modules.NetModule
import com.mercadolibre.camilogo1200.data.di.modules.PersistenceModule
import com.mercadolibre.camilogo1200.domain.di.modules.SiteRepositoryModule
import com.mercadolibre.camilogo1200.domain.repository.ISiteRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DispatchersModule::class, NetModule::class, PersistenceModule::class, SiteRepositoryModule::class])
interface DataComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): DataComponent
    }

    fun providesSiteRepository(): ISiteRepository
}