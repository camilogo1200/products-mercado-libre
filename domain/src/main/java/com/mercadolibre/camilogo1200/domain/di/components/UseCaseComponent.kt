package com.mercadolibre.camilogo1200.domain.di.components

import android.content.Context
import com.mercadolibre.camilogo1200.data.di.modules.DispatchersModule
import com.mercadolibre.camilogo1200.data.di.modules.NetModule
import com.mercadolibre.camilogo1200.data.di.modules.PersistenceModule
import com.mercadolibre.camilogo1200.domain.di.modules.SiteRepositoryModule
import com.mercadolibre.camilogo1200.domain.di.modules.UseCaseModule
import com.mercadolibre.camilogo1200.domain.usecases.interfaces.IGetSitesInteractor
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UseCaseModule::class, SiteRepositoryModule::class, DispatchersModule::class, NetModule::class, PersistenceModule::class])
interface UseCaseComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): UseCaseComponent
    }

    fun providesGetSitesUseCase(): IGetSitesInteractor

}