package com.example.controlgastos.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlgastos.models.Income
import com.example.controlgastos.models.RecordStatus

@Dao
interface IncomeDao {
    @Query("SELECT * FROM incomes WHERE periodId = :periodId ORDER BY date DESC")
    fun getIncomesByPeriod(periodId: Long): LiveData<List<Income>>
    
    @Query("SELECT * FROM incomes WHERE id = :id")
    suspend fun getIncomeById(id: Long): Income?
    
    @Query("SELECT * FROM incomes WHERE periodId = :periodId")
    suspend fun getIncomesByPeriodSync(periodId: Long): List<Income>
    
    @Insert
    suspend fun insert(income: Income): Long
    
    @Update
    suspend fun update(income: Income)
    
    @Delete
    suspend fun delete(income: Income)
    
    @Query("UPDATE incomes SET status = :status WHERE id = :id")
    suspend fun updateStatus(id: Long, status: RecordStatus)
}
