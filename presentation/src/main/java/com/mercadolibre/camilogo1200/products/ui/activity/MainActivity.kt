package com.mercadolibre.camilogo1200.products.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mercadolibre.camilogo1200.products.R
import com.mercadolibre.camilogo1200.products.ui.fragments.SplashScreenFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SplashScreenFragment.newInstance())
                    .commitNow()
        }
    }
}