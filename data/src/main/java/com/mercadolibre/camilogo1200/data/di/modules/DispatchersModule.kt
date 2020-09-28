package com.mercadolibre.camilogo1200.data.di.modules

import com.mercadolibre.camilogo1200.data.di.DefaultDispatcher
import com.mercadolibre.camilogo1200.data.di.IoDispatcher
import com.mercadolibre.camilogo1200.data.di.MainDispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module

class DispatchersModule {
    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}