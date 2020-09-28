package com.mercadolibre.camilogo1200.data.di.modules

import android.content.Context
import com.mercadolibre.camilogo1200.data.di.providers.NetworkChecker
import com.mercadolibre.camilogo1200.data.net.RetrofitServiceBuilder
import com.mercadolibre.camilogo1200.data.net.api.ISitesApi
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class NetModule {
    @Provides
    @Singleton
    fun provideRetrofitBuilder(): RetrofitServiceBuilder.Builder {
        return RetrofitServiceBuilder.newBuilder()
    }

    @Provides
    @Singleton
    fun provideSiteServiceApi(
        builder: RetrofitServiceBuilder.Builder
    ): ISitesApi {
        return with(builder) {
            setBaseUrl("https://api.mercadolibre.com/sites/")
                .addScalarsConverterFactory(true)
                .enableGsonConverterFactory(true)
                .enableGzipCompression(true)
                .enableLoggingInterceptor(true)
                .enableLoggingInterceptor(true)
                .setLoggingLevelInterceptor(HttpLoggingInterceptor.Level.BODY)
                .enableStethoInterceptor(true)
        }.create(ISitesApi::class.java)
    }

    @Provides
    @Singleton
    internal fun provideNetworkChecker(context: Context): NetworkChecker = NetworkChecker(context)
}