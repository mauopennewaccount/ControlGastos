package com.example.controlgastos.database

import androidx.lifecycle.LiveData
import com.example.controlgastos.models.*

class AppRepository(private val database: AppDatabase) {
    
    // Categories
    val allCategories: LiveData<List<Category>> = database.categoryDao().getAllCategories()
    
    suspend fun insertCategory(category: Category) = database.categoryDao().insert(category)
    suspend fun updateCategory(category: Category) = database.categoryDao().update(category)
    suspend fun deleteCategory(category: Category) = database.categoryDao().delete(category)
    
    // Subcategories
    val allSubcategories: LiveData<List<Subcategory>> = database.subcategoryDao().getAllSubcategories()
    
    fun getSubcategoriesByCategory(categoryId: Long): LiveData<List<Subcategory>> = 
        database.subcategoryDao().getSubcategoriesByCategory(categoryId)
    
    suspend fun insertSubcategory(subcategory: Subcategory) = database.subcategoryDao().insert(subcategory)
    suspend fun updateSubcategory(subcategory: Subcategory) = database.subcategoryDao().update(subcategory)
    suspend fun deleteSubcategory(subcategory: Subcategory) = database.subcategoryDao().delete(subcategory)
    
    // Periods
    val allPeriods: LiveData<List<Period>> = database.periodDao().getAllPeriods()
    
    suspend fun insertPeriod(period: Period): Long = database.periodDao().insert(period)
    suspend fun updatePeriod(period: Period) = database.periodDao().update(period)
    suspend fun deletePeriod(period: Period) = database.periodDao().delete(period)
    suspend fun getPeriodById(id: Long): Period? = database.periodDao().getPeriodById(id)
    
    // Incomes
    fun getIncomesByPeriod(periodId: Long): LiveData<List<Income>> = 
        database.incomeDao().getIncomesByPeriod(periodId)
    
    suspend fun insertIncome(income: Income): Long = database.incomeDao().insert(income)
    suspend fun updateIncome(income: Income) = database.incomeDao().update(income)
    suspend fun deleteIncome(income: Income) = database.incomeDao().delete(income)
    suspend fun updateIncomeStatus(id: Long, status: RecordStatus) = 
        database.incomeDao().updateStatus(id, status)
    
    // Expenses
    fun getExpensesByPeriod(periodId: Long): LiveData<List<Expense>> = 
        database.expenseDao().getExpensesByPeriod(periodId)
    
    suspend fun insertExpense(expense: Expense): Long = database.expenseDao().insert(expense)
    suspend fun updateExpense(expense: Expense) = database.expenseDao().update(expense)
    suspend fun deleteExpense(expense: Expense) = database.expenseDao().delete(expense)
    suspend fun updateExpenseStatus(id: Long, status: RecordStatus) = 
        database.expenseDao().updateStatus(id, status)
    
    // Clone Period
    suspend fun clonePeriod(sourcePeriodId: Long, newPeriodName: String, startDate: Long, endDate: Long): Long {
        // Create new period
        val newPeriodId = insertPeriod(Period(name = newPeriodName, startDate = startDate, endDate = endDate))
        
        // Clone incomes
        val incomes = database.incomeDao().getIncomesByPeriodSync(sourcePeriodId)
        incomes.forEach { income ->
            insertIncome(income.copy(id = 0, periodId = newPeriodId))
        }
        
        // Clone expenses
        val expenses = database.expenseDao().getExpensesByPeriodSync(sourcePeriodId)
        expenses.forEach { expense ->
            insertExpense(expense.copy(id = 0, periodId = newPeriodId))
        }
        
        return newPeriodId
    }
}
