package com.example.controlgastos.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlgastos.data.entities.Period

@Dao
interface PeriodDao {
    @Query("SELECT * FROM periods ORDER BY startDate DESC")
    fun getAllPeriods(): LiveData<List<Period>>
    
    @Query("SELECT * FROM periods WHERE id = :id")
    suspend fun getPeriodById(id: Long): Period?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(period: Period): Long
    
    @Update
    suspend fun update(period: Period)
    
    @Delete
    suspend fun delete(period: Period)
    
    @Query("DELETE FROM periods WHERE id = :id")
    suspend fun deleteById(id: Long)
    
    @Query("SELECT * FROM periods WHERE :timestamp BETWEEN startDate AND endDate LIMIT 1")
    suspend fun getPeriodForDate(timestamp: Long): Period?
}
