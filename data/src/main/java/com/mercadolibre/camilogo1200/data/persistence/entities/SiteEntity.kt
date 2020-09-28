package com.mercadolibre.camilogo1200.data.persistence.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mercadolibre.camilogo1200.data.persistence.entities.SiteEntity.Companion.SITE_TABLE_NAME

@Entity(tableName = SITE_TABLE_NAME)
data class SiteEntity constructor(
    @PrimaryKey @ColumnInfo(name = SITE_ID) val id: String,
    @ColumnInfo(name = SITE_NAME) val name: String,
    @ColumnInfo(name = SITE_COUNTRY_ID) val countryId: String,
    @ColumnInfo(name = SITE_MERCADO_PAGO_VERSION) val mercadoPagoVersion: Int,
    @ColumnInfo(name = SITE_DEFAULT_CURRENCY_ID) val defaultCurrencyId: String,
) {
    companion object {
        //Table Name
        const val SITE_TABLE_NAME = "site"

        //fields
        const val SITE_ID = "id"
        const val SITE_NAME = "name"
        const val SITE_COUNTRY_ID = "country_id"
        const val SITE_MERCADO_PAGO_VERSION = "mercadopago_version"
        const val SITE_DEFAULT_CURRENCY_ID = "default_currency_id"
    }

}