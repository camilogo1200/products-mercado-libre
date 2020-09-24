package com.mercadolibre.camilogo1200.products.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mercadolibre.camilogo1200.products.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportActionBar?.hide()
    }
}