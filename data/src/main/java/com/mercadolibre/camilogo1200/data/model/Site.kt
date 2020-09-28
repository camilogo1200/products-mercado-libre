package com.mercadolibre.camilogo1200.data.model

data class Site(
    val id: String,
    val name: String,
    val countryId: String?,
    val mercadoPagoVersion: Int?,
    val defaultCurrencyId: String,
)