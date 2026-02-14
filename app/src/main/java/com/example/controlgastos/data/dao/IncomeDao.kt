package com.example.controlgastos.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlgastos.data.entities.Income

@Dao
interface IncomeDao {
    @Query("SELECT * FROM incomes ORDER BY date DESC")
    fun getAllIncomes(): LiveData<List<Income>>
    
    @Query("SELECT * FROM incomes WHERE periodId = :periodId ORDER BY date DESC")
    fun getIncomesByPeriod(periodId: Long): LiveData<List<Income>>
    
    @Query("SELECT * FROM incomes WHERE id = :id")
    suspend fun getIncomeById(id: Long): Income?
    
    @Query("SELECT SUM(amount) FROM incomes WHERE periodId = :periodId")
    suspend fun getTotalIncomeByPeriod(periodId: Long): Double?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(income: Income): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(incomes: List<Income>)
    
    @Update
    suspend fun update(income: Income)
    
    @Delete
    suspend fun delete(income: Income)
    
    @Query("DELETE FROM incomes WHERE id = :id")
    suspend fun deleteById(id: Long)
}
