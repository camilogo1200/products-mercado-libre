package com.mercadolibre.camilogo1200.data.persistence.source

import android.content.Context
import androidx.room.Room
import com.mercadolibre.camilogo1200.data.R

object DatabaseFactory {
    fun getDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            context.getString(R.string.DATABASE_NAME)
        ).build()
}