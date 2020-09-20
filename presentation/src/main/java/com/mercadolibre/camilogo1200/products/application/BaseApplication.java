package com.mercadolibre.camilogo1200.products.application;

import android.app.Application;

/**
 * Abstract base class used to generate a hierarchy of behaviours cuatomized for the product app
 * extends from the android application class {@link Application}
 *
 * @author Cristhian C. Gómez N
 * @see android.app.Application
 * @since 1.0
 */
public abstract class BaseApplication extends Application {

    /**
     * Abstract method called for initialization on child classes
     * or other modules
     */
    protected abstract void onAppCreated();

    /**
     * Abstract method called or intended to be called for destroy memory
     * on child classes or other modules avoiding memory leaks
     */
    protected abstract void onAppDestroyed();

    /**
     * Called when the activity is starting.
     *
     * @see Application#onCreate()
     */
    @Override
    public void onCreate() {
        super.onCreate();
        onAppCreated();
    }
}
