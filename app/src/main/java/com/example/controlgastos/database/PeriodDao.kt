package com.example.controlgastos.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlgastos.models.Period

@Dao
interface PeriodDao {
    @Query("SELECT * FROM periods ORDER BY startDate DESC")
    fun getAllPeriods(): LiveData<List<Period>>
    
    @Query("SELECT * FROM periods WHERE id = :id")
    suspend fun getPeriodById(id: Long): Period?
    
    @Insert
    suspend fun insert(period: Period): Long
    
    @Update
    suspend fun update(period: Period)
    
    @Delete
    suspend fun delete(period: Period)
}
