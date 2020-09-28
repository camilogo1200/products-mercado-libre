package com.mercadolibre.camilogo1200.data.persistence.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mercadolibre.camilogo1200.data.persistence.dao.SiteDao
import com.mercadolibre.camilogo1200.data.persistence.entities.SiteEntity

@Database(entities = [SiteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun siteDao(): SiteDao
}