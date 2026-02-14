package com.example.controlgastos.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlgastos.data.entities.Expense
import com.example.controlgastos.data.entities.ExpenseStatus

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAllExpenses(): LiveData<List<Expense>>
    
    @Query("SELECT * FROM expenses WHERE periodId = :periodId ORDER BY date DESC")
    fun getExpensesByPeriod(periodId: Long): LiveData<List<Expense>>
    
    @Query("SELECT * FROM expenses WHERE status = :status ORDER BY date DESC")
    fun getExpensesByStatus(status: ExpenseStatus): LiveData<List<Expense>>
    
    @Query("SELECT * FROM expenses WHERE id = :id")
    suspend fun getExpenseById(id: Long): Expense?
    
    @Query("SELECT SUM(amount) FROM expenses WHERE periodId = :periodId")
    suspend fun getTotalExpenseByPeriod(periodId: Long): Double?
    
    @Query("SELECT SUM(amount) FROM expenses WHERE periodId = :periodId AND status = :status")
    suspend fun getTotalExpenseByPeriodAndStatus(periodId: Long, status: ExpenseStatus): Double?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense: Expense): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(expenses: List<Expense>)
    
    @Update
    suspend fun update(expense: Expense)
    
    @Delete
    suspend fun delete(expense: Expense)
    
    @Query("DELETE FROM expenses WHERE id = :id")
    suspend fun deleteById(id: Long)
}
