package com.mercadolibre.camilogo1200.products.ui.activity

import android.os.Bundle
import com.mercadolibre.camilogo1200.products.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportActionBar?.hide()
    }
}