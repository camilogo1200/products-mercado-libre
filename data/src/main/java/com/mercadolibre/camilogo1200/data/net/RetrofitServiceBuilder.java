package com.mercadolibre.camilogo1200.data.net;

import androidx.annotation.NonNull;

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor;
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mercadolibre.camilogo1200.data.BuildConfig;
import com.mercadolibre.camilogo1200.data.net.helpers.GzipRequestInterceptor;
import com.mercadolibre.camilogo1200.data.net.helpers.PrintingEventListener;
import com.mercadolibre.camilogo1200.data.net.interfaces.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Defines a implemetation of a builder pattern for the Retrofit service
 * api abstraction which makes easy to configure a brand new service
 * in a builder manner.
 * <p>
 * <li>This class has a internal class {@link Builder} which implements the interface
 * {@link RetrofitBuilder}
 * the only intended way to instantiate is through the {@link RetrofitServiceBuilder#newBuilder()}
 * method.
 *
 * @author Cristhian C. Gómez N
 * @see RetrofitBuilder
 * @since 1.0
 */
public final class RetrofitServiceBuilder {
    /**
     * Sole constructor. (Declared private avoiding undesirable instantiation)
     */
    private RetrofitServiceBuilder() {
    }

    /**
     * Intended as the only way to create a new instance of {@link RetrofitServiceBuilder.Builder}
     * <p>
     *
     * @return Gets a new instance of the {@link RetrofitServiceBuilder.Builder}
     */
    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The factual class that implements the {@link RetrofitBuilder} interface
     * and implements the Builder pattern
     *
     * @author Cristhian C. Gómez N
     * @since 1.0
     */
    public static final class Builder implements RetrofitBuilder {
        HttpLoggingInterceptor loggingInterceptor;
        private Retrofit.Builder retrofitBuilder;
        private OkHttpClient.Builder okHttpClient;
        private String baseURL;
        private boolean enableLoggingInterceptor;
        private boolean enableGZipCompression;
        private boolean disableSensibleInformation;
        private boolean enableNetEventListeners;
        private boolean enableGsonConverter;
        private HttpLoggingInterceptor.Level level;
        private List<Converter.Factory> converterFactories;
        private List<Interceptor> lInterceptors;
        private List<Interceptor> lNetworkInterceptors;
        private boolean enableScalarConverter;
        private boolean enableStetho;
        private boolean enableFlipper;
        private NetworkFlipperPlugin networkFlipperPlugin;
        private boolean enableRxJava3;

        /**
         * Sole constructor. Initialize the Collections required by the class build
         */
        public Builder() {
            retrofitBuilder = new Retrofit.Builder();
            okHttpClient = new OkHttpClient.Builder();
            converterFactories = new ArrayList<>();
            lInterceptors = new ArrayList<>();
            lNetworkInterceptors = new ArrayList<>();
            level = HttpLoggingInterceptor.Level.BASIC;
            loggingInterceptor = new HttpLoggingInterceptor();
        }

        /**
         * This method is intended to activate or deactivate the GZip compression
         * over the Network request through {@link Retrofit}
         * <p> Gzip Compression is deactivated by default</p>
         *
         * @param enable if true enables GZip Compression on network request
         * @return {@link RetrofitServiceBuilder.Builder}
         * @since 1.0
         */
        @Override
        public Builder enableGzipCompression(boolean enable) {
            enableGZipCompression = enable;
            return this;
        }

        /**
         * This method is intended to activate or deactivate the Logger interceptor
         * over the Network request through {@link Retrofit}
         *
         * @param enable if true enables Logging interceptor in {@link Retrofit} on network request calls
         * @return {@link RetrofitServiceBuilder.Builder}
         * @since 1.0
         */
        @Override
        public Builder enableLoggingInterceptor(boolean enable) {
            enableLoggingInterceptor = enable;
            return this;
        }

        /**
         * This method allows the configuration of the logging level
         * over the Network request through {@link Retrofit}
         * <p> Level by default is {@link HttpLoggingInterceptor.Level#BASIC} </p>
         *
         * @param level {@link Retrofit} Logging level on network request calls
         * @return {@link RetrofitServiceBuilder.Builder}
         * @see HttpLoggingInterceptor.Level
         * @since 1.0
         */
        @Override
        public Builder setLoggingLevelInterceptor(HttpLoggingInterceptor.Level level) {
            this.level = level;
            return this;
        }

        /**
         * This method allows the configuration over the logging of  security parameter
         * over the Network request through {@link Retrofit} such as the authorization or token
         * parameters in the headers of the request
         * <p> By default Authorization &amp Cookie are not logged on the logging mechanism</p>
         *
         * @param disable Logging of the content of security related headers
         * @return {@link RetrofitServiceBuilder.Builder}
         * @see HttpLoggingInterceptor#redactHeader(String)
         * @see Retrofit
         * @since 1.0
         */
        @Override
        public Builder disableSensibleInformationfilter(boolean disable) {
            disableSensibleInformation = disable;
            return this;
        }

        @Override
        public Builder enableNetworkEventListeners(boolean enable) {
            enableNetEventListeners = enable;
            return this;
        }

        /**
         * Sets the  web service endpoint {@link retrofit2.http.Url} url base
         * over the Network request using {@link Retrofit}
         *
         * <p> By default the base url is null</p>
         *
         * @param baseUrl the web service endpoint url base
         * @return {@link RetrofitServiceBuilder.Builder}
         * @see Retrofit
         * @see retrofit2.http.Url
         * @since 1.0
         */
        @Override
        public Builder setBaseUrl(@NonNull String baseUrl) {
            this.baseURL = baseUrl;
            return this;
        }

        /**
         * Adds a Converter Factory {@link Converter.Factory}
         * for the Network request in {@link Retrofit}
         *
         * @param factory the converter factory
         * @return {@link RetrofitServiceBuilder.Builder}
         * @see Retrofit
         * @see Converter.Factory
         * @since 1.0
         */
        @Override
        public Builder addConverterFactory(Converter.Factory factory) {
            converterFactories.add(factory);
            return this;
        }

        /**
         * Enables GSON {@link GsonConverterFactory} as the main handler for parsing on
         * the Network request in {@link Retrofit}
         *
         * @param enable true enables the GSONFactory as the main handler for parsing DTOs
         * @return {@link RetrofitServiceBuilder.Builder}
         * @see Retrofit
         * @see GsonConverterFactory
         * @see Converter.Factory
         * @since 1.0
         */
        @Override
        public Builder enableGsonConverterFactory(boolean enable) {
            enableGsonConverter = enable;
            return this;
        }

        /**
         * Enables Scalars {@link ScalarsConverterFactory} as the main handler for parsing on
         * the Network request in {@link Retrofit} on the base types
         *
         * @param enable true enables the ScalarsFactory as the main handler for parsing
         *               base properties
         * @return {@link RetrofitServiceBuilder.Builder}
         * @see Retrofit
         * @see ScalarsConverterFactory
         * @see Converter.Factory
         * @since 1.0
         */
        @Override
        public Builder addScalarsConverterFactory(boolean enable) {
            enableScalarConverter = enable;
            return this;
        }

        /**
         * Adds an OkHttp3Client {@link OkHttpClient} interceptor {@link Interceptor}
         * over the network request in {@link Retrofit}
         *
         * @param interceptor the interceptor {@link Interceptor}
         * @return {@link RetrofitServiceBuilder.Builder}
         * @see Retrofit
         * @see Interceptor
         * @see OkHttpClient
         * @since 1.0
         */
        @Override
        public Builder addInterceptor(Interceptor interceptor) {
            lInterceptors.add(interceptor);
            return this;
        }

        /**
         * Adds an OkHttp3Client {@link OkHttpClient} interceptor {@link Interceptor}
         * over the network request in {@link Retrofit} using the addnetwork method provided by OkHttp3
         * {@link OkHttpClient#newBuilder()#addNetworkInterceptor}
         *
         * @param interceptor the network interceptor {@link Interceptor}
         * @return {@link RetrofitServiceBuilder.Builder}
         * @see Retrofit
         * @see Interceptor
         * @see OkHttpClient
         * @since 1.0
         */
        @Override
        public Builder addNetworkInterceptor(Interceptor interceptor) {
            lNetworkInterceptors.add(interceptor);
            return this;
        }

        /**
         * Activate the Stetho {@link com.facebook.stetho.Stetho} network handler
         * over the network request in {@link Retrofit}
         * <p> By default is enabled on Debug Mode</p>
         *
         * @param enable true enables the Stetho Interceptor {@link com.facebook.stetho.okhttp3.StethoInterceptor}
         * @return {@link RetrofitServiceBuilder.Builder}
         * @see Retrofit
         * @see Interceptor
         * @see com.facebook.stetho.Stetho
         * @see com.facebook.stetho.okhttp3.StethoInterceptor
         * @since 1.0
         */
        @Override
        public Builder enableStethoInterceptor(boolean enable) {
            enableStetho = enable;
            return this;
        }

        /**
         * Activate the Flipper {@link com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor} network {@link OkHttpClient} Interceptor
         * over the network request in {@link Retrofit}
         * <p> By default is enabled on Debug Mode</p>
         *
         * @param enable true enables the Flipper Interceptor {@link com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor}
         * @return {@link RetrofitServiceBuilder.Builder}
         * @see Retrofit
         * @see Interceptor
         * @see NetworkFlipperPlugin
         * @see com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
         * @see com.facebook.flipper.core.FlipperClient
         * @since 1.0
         */
        @Override
        public Builder enableFlipperInterceptor(boolean enable, NetworkFlipperPlugin networkPlugin) {
            enableFlipper = enable;
            networkFlipperPlugin = networkPlugin;
            return this;
        }

        /**
         * Activate the use of the ReactiveExtensions Call Adapter so called the RxJava
         * {@link RxJava3CallAdapterFactory} network
         * over the network request in {@link Retrofit}
         *
         * <p> By default is disabled</p>
         *
         * @param enable true enables the RxJava Call Adapter {@link RxJava3CallAdapterFactory}
         * @return {@link RetrofitServiceBuilder.Builder}
         * @see Retrofit
         * @see RxJava3CallAdapterFactory
         * @see io.reactivex.rxjava3.plugins.RxJavaPlugins
         * @see io.reactivex.rxjava3.core.Observable
         * @since 1.0
         */
        @Override
        public Builder enableRxJava3Converter(boolean enable) {
            enableRxJava3 = enable;
            return this;
        }

        /**
         * Create an implementation of the API endpoints defined by the {@code serviceClass} interface {@link Retrofit}
         *
         * @param serviceClass service {@code serviceClass}
         * @return {@code T} Service class implementation
         * @see Retrofit
         * @see Retrofit#create(Class)
         * @since 1.0
         */
        @Override
        public <T> T create(Class<T> serviceClass) {


            if (baseURL == null || baseURL.isEmpty()) {
                throw new IllegalArgumentException("Invalid URL [" + baseURL + "]");
            }
            retrofitBuilder.baseUrl(baseURL);
            if (enableLoggingInterceptor) {
                loggingInterceptor.setLevel(level);

                if (!disableSensibleInformation) {
                    loggingInterceptor.redactHeader("Authorization");
                    loggingInterceptor.redactHeader("Cookie");
                }
            }
            addConverters();
            addInterceptors();
            addDebugHelpers();

            Retrofit.Builder builder = retrofitBuilder
                    .client(okHttpClient.build());
            if (enableRxJava3) {
                builder.addCallAdapterFactory(RxJava3CallAdapterFactory.create());
            }
            return builder.build()
                    .create(serviceClass);
        }

        /**
         * Helper method {@link #create(Class)} that adds different debug helpers
         *
         * @see com.facebook.stetho.okhttp3.StethoInterceptor
         * @see com.facebook.stetho.Stetho
         * @see com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
         * @see com.mercadolibre.camilogo1200.data.net.helpers.PrintingEventListener
         * @see okhttp3.EventListener
         * @see Retrofit
         * @since 1.0
         */
        private void addDebugHelpers() {
            if (BuildConfig.DEBUG) {
                if (enableStetho) {
                    okHttpClient.addNetworkInterceptor(new StethoInterceptor());
                }

                if (enableFlipper) {
                    okHttpClient.addNetworkInterceptor(new FlipperOkhttpInterceptor(networkFlipperPlugin));
                }

                if (enableNetEventListeners || BuildConfig.NETWORK_EVENTS_LISTENER) {
                    okHttpClient.eventListenerFactory(PrintingEventListener.FACTORY);
                }
            }
        }

        /**
         * Helper method for {@link #create(Class)} that adds different Converters
         *
         * @see GsonConverterFactory
         * @see ScalarsConverterFactory
         * @see com.google.gson.Gson
         * @see Converter.Factory
         * @see Retrofit
         * @since 1.0
         */
        private void addConverters() {

            if (converterFactories != null) {
                for (Converter.Factory factory : converterFactories) {
                    retrofitBuilder.addConverterFactory(factory);
                }
            }

            if (enableGsonConverter) {
                retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
            }

            if (enableScalarConverter) {
                retrofitBuilder.addConverterFactory(ScalarsConverterFactory.create());
            }
        }

        /**
         * Helper method for {@link #create(Class)} that adds different Interceptors {@link Interceptor}
         *
         * @see Interceptor
         * @see OkHttpClient
         * @see Retrofit
         * @since 1.0
         */
        private void addInterceptors() {
            if (enableGZipCompression) {
                okHttpClient.addNetworkInterceptor(new GzipRequestInterceptor());
            }
            if (lInterceptors != null) {
                for (Interceptor i : lInterceptors) {
                    okHttpClient.addInterceptor(i);
                }
            }

            if (lNetworkInterceptors != null) {
                for (Interceptor i : lNetworkInterceptors) {
                    okHttpClient.addNetworkInterceptor(i);
                }
            }
        }

    }

}