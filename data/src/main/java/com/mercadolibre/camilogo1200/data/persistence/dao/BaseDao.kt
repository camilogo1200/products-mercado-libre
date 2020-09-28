package com.mercadolibre.camilogo1200.data.persistence.dao

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: T): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(obj: T): Int

    @Delete
    suspend fun delete(obj: T): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg obj: T): kotlin.collections.List<Long>

    @Delete
    suspend fun deleteAll(vararg obj: T): Int
}
