package com.example.controlgastos.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlgastos.models.Expense
import com.example.controlgastos.models.RecordStatus

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expenses WHERE periodId = :periodId ORDER BY date DESC")
    fun getExpensesByPeriod(periodId: Long): LiveData<List<Expense>>
    
    @Query("SELECT * FROM expenses WHERE id = :id")
    suspend fun getExpenseById(id: Long): Expense?
    
    @Query("SELECT * FROM expenses WHERE periodId = :periodId")
    suspend fun getExpensesByPeriodSync(periodId: Long): List<Expense>
    
    @Insert
    suspend fun insert(expense: Expense): Long
    
    @Update
    suspend fun update(expense: Expense)
    
    @Delete
    suspend fun delete(expense: Expense)
    
    @Query("UPDATE expenses SET status = :status WHERE id = :id")
    suspend fun updateStatus(id: Long, status: RecordStatus)
}
