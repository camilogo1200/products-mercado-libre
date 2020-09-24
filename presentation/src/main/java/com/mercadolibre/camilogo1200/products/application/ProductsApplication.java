package com.mercadolibre.camilogo1200.products.application;

import android.app.Application;
import android.content.Context;

import com.facebook.flipper.android.AndroidFlipperClient;
import com.facebook.flipper.android.utils.FlipperUtils;
import com.facebook.flipper.core.FlipperClient;
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin;
import com.facebook.flipper.plugins.inspector.DescriptorMapping;
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin;
import com.facebook.flipper.plugins.leakcanary.LeakCanaryFlipperPlugin;
import com.facebook.flipper.plugins.litho.LithoFlipperDescriptors;
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin;
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin;
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin;
import com.facebook.soloader.SoLoader;
import com.facebook.stetho.Stetho;
import com.mercadolibre.camilogo1200.products.BuildConfig;
import com.mercadolibre.camilogo1200.products.R;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import org.jetbrains.annotations.NotNull;

import okhttp3.OkHttpClient;
import timber.log.Timber;

/**
 * Application class for the products app which extends from the {@link BaseApplication}
 *
 * @author Cristhian C. Gómez N
 * @see BaseApplication
 * @see android.app.Application
 * @since 1.0
 */
public class ProductsApplication extends BaseApplication {
    /**
     * field required for the initialization of the network flipper plugin {@link NetworkFlipperPlugin},
     * it is also used to configure the network interceptor {@link okhttp3.Interceptor}
     * {@link OkHttpClient} in Retrofit {@link retrofit2.Retrofit} to log the network request.
     */
    private final NetworkFlipperPlugin networkFlipperPlugin = new NetworkFlipperPlugin();
    /**
     * static field that represents the singleton on application
     */
    private static ProductsApplication application;

    /*
     * Sole constructor. Made it private to avoid undesirable class instantiation
     * breaking the singleton pattern implementation
     * */
    public ProductsApplication() {
        application = this;
    }

    /**
     * Gets the application singleton. static class reference.
     *
     * @return static singleton of application class {@link ProductsApplication#application}
     * @throws IllegalStateException if for any reason this method is called after
     *                               the android lifecycle onCreate method {@link Application#onCreate()} is called
     *                               which makes the application class (Singleton) useless, having no context.
     * @author Cristhian C. Gómez N
     * @see Application
     * @since 1.0
     */
    public static ProductsApplication getInstance() {
        if (application == null) {
            throw new IllegalStateException("Application illegal initialization state");
        }
        return application;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onAppCreated() {
        initializeLoggerConfiguration();
        initializeDebugConfiguration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onAppDestroyed() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    /**
     * Initialize Debug tool configurations in the application
     * use debug flag parameter {@link BuildConfig#DEBUG} to
     * configure the tooling system, if this parameter is <code>false</code>
     * does not configure the debug tooling system.
     * <h3>Stetho Configuration</h3>>
     * <p>
     * Configures Stetho {@link Stetho} if the flag in the ProductFlavor
     * contained in the build.gradle is true {@link BuildConfig#STETHO}
     * </p>
     *
     * <h3>Flipper Debug Configuration</h3>
     * <p>
     * Configures Flipper {@linkplain <a href="https://fbflipper.com/docs/getting-started/index/">Faceboook Flipper Developers Sites</a>}
     * using the method shouldEnableFlipper available in the FlipperUtils package {@link FlipperUtils#shouldEnableFlipper(Context)}.
     * This helper mehod configures the following components :
     * <ul>
     *  <li>NavigationFlipperPlugin {@link NavigationFlipperPlugin}</li>
     *  <li>NetworkFlipperPlugin {@link NetworkFlipperPlugin}</li>
     *  <li>DatabasesFlipperPlugin {@link DatabasesFlipperPlugin}</li>
     *  <li>LeakCanaryFlipperPlugin {@link LeakCanaryFlipperPlugin}</li>
     *  <li>SharedPreferencesFlipperPlugin {@link SharedPreferencesFlipperPlugin}</li>
     *  <li>InspectorFlipperPlugin {@link InspectorFlipperPlugin}</li>
     * </ul>
     * </p>
     *
     * @author Cristhian C. Gómez N.
     * @see Stetho
     * @see FlipperClient
     * @see FlipperUtils
     * @see SoLoader
     * @see LithoFlipperDescriptors
     * @since 1.0
     */
    private void initializeDebugConfiguration() {

        if (!BuildConfig.DEBUG) return;

        if (BuildConfig.STETHO) {
            /*Stetho initialization*/
            Stetho.initializeWithDefaults(this);
        }
        if (FlipperUtils.shouldEnableFlipper(this)) {
            /* flipper initialization */
            SoLoader.init(this, false);

            final DescriptorMapping descriptorMapping = DescriptorMapping.withDefaults();
            LithoFlipperDescriptors.add(descriptorMapping);

            final FlipperClient client = AndroidFlipperClient.getInstance(this);
            client.addPlugin(NavigationFlipperPlugin.getInstance());
            client.addPlugin(networkFlipperPlugin);
            client.addPlugin(new DatabasesFlipperPlugin(this));
            client.addPlugin(new LeakCanaryFlipperPlugin());
            client.addPlugin(new SharedPreferencesFlipperPlugin(this, getString(R.string.shared_preferences_file_name)));
            client.addPlugin(new InspectorFlipperPlugin(this, descriptorMapping));
            client.start();

            Timber.i("Timber - initializeDebugConfiguration Successfully initialized");
        }
    }

    /**
     * Initialize the configurations for logging properly in the application
     * using a logger implementation {@link Logger} and {@link AndroidLogAdapter}
     * {@link FormatStrategy} &amp {@link PrettyFormatStrategy}
     * also overrides {@link Timber#plant(Timber.Tree)} the behaviour
     * in Timber {@link Timber} library.
     *
     * @author Cristhian C. Gómez N.
     * @see Timber
     * @see Logger
     * @see AndroidLogAdapter
     * @see FormatStrategy
     * @see PrettyFormatStrategy
     * @since 1.0
     */
    private void initializeLoggerConfiguration() {
        FormatStrategy logcatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(4)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag(getString(R.string.app_global_log_tag))   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(logcatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });

        Timber.plant(new Timber.DebugTree() {
            @Override
            protected void log(int priority, String tag, @NotNull String message, Throwable t) {
                Logger.log(priority, tag, message, t);
            }
        });
    }

}