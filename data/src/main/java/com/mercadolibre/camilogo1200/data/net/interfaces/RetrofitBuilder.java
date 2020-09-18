package com.mercadolibre.camilogo1200.data.net.interfaces;

import androidx.annotation.NonNull;

import com.facebook.flipper.plugins.network.NetworkFlipperPlugin;
import com.mercadolibre.camilogo1200.data.net.RetrofitServiceBuilder;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;

/**
 * Defines the methods that define the behaviour of the Builder pattern for Retrofit helper
 *
 * @author Cristhian C. Gómez N
 * @see <a href="https://refactoring.guru/design-patterns/builder">Refactoring Guru - Builder pattern site</a>
 * @see <a href="https://en.wikipedia.org/wiki/Builder_pattern">Wikipedia - Builder pattern site</a>
 * @see retrofit2.Retrofit
 * @see RetrofitServiceBuilder
 * @since 1.0
 */
public interface RetrofitBuilder {
    RetrofitServiceBuilder.Builder enableGzipCompression(boolean enable);

    RetrofitServiceBuilder.Builder enableLoggingInterceptor(boolean enable);

    RetrofitServiceBuilder.Builder setLoggingLevelInterceptor(HttpLoggingInterceptor.Level level);

    RetrofitServiceBuilder.Builder disableSensibleInformationfilter(boolean disable);

    RetrofitServiceBuilder.Builder enableNetworkEventListeners(boolean enable);

    RetrofitServiceBuilder.Builder setBaseUrl(@NonNull String baseUrl);

    RetrofitServiceBuilder.Builder addConverterFactory(Converter.Factory factory);

    RetrofitServiceBuilder.Builder enableGsonConverterFactory(boolean enable);

    RetrofitServiceBuilder.Builder addScalarsConverterFactory(boolean enable);

    RetrofitServiceBuilder.Builder addInterceptor(Interceptor interceptor);

    RetrofitServiceBuilder.Builder addNetworkInterceptor(Interceptor interceptor);

    RetrofitServiceBuilder.Builder enableStethoInterceptor(boolean enable);

    RetrofitServiceBuilder.Builder enableFlipperInterceptor(boolean enable, NetworkFlipperPlugin networkPlugin);

    RetrofitServiceBuilder.Builder enableRxJava3Converter(boolean enable);

    <T> T create(final Class<T> service);
}
