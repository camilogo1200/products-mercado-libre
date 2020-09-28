package com.mercadolibre.camilogo1200.data.persistence.dao

import androidx.room.Dao
import androidx.room.Query
import com.mercadolibre.camilogo1200.data.persistence.entities.SiteEntity
import io.reactivex.rxjava3.core.Observable

/**
 *
 *
 * @author Cristhian C Gómez N
 * @since 1.0.0
 */
@Dao
interface SiteDao : BaseDao<SiteEntity> {
    /**
     * Select all sites in database
     *
     * @return a [MutableList] of [SiteEntity]
     * @see MutableList
     * @see SiteEntity
     * @see Observable
     * @author Cristhian C Gómez N
     * @since 1.0.0
     */
    @Query("SELECT * FROM site ORDER BY name DESC")
    suspend fun getAllSites(): MutableList<SiteEntity>

    @Query("SELECT Count(*) FROM site")
    suspend fun count(): Int
}