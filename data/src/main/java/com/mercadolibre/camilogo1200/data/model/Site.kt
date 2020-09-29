package com.mercadolibre.camilogo1200.data.model

import android.os.Parcel
import android.os.Parcelable

data class Site(
    val id: String?,
    val name: String?,
    val countryId: String?,
    val mercadoPagoVersion: Int?,
    val defaultCurrencyId: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(countryId)
        parcel.writeValue(mercadoPagoVersion)
        parcel.writeString(defaultCurrencyId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Site> {
        override fun createFromParcel(parcel: Parcel): Site {
            return Site(parcel)
        }

        override fun newArray(size: Int): Array<Site?> {
            return arrayOfNulls(size)
        }
    }
}