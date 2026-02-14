package com.example.controlgastos.data.repository

import androidx.lifecycle.LiveData
import com.example.controlgastos.data.dao.*
import com.example.controlgastos.data.entities.*

class ExpenseRepository(
    private val expenseDao: ExpenseDao,
    private val incomeDao: IncomeDao,
    private val categoryDao: CategoryDao,
    private val subcategoryDao: SubcategoryDao,
    private val periodDao: PeriodDao
) {
    // Expenses
    fun getAllExpenses(): LiveData<List<Expense>> = expenseDao.getAllExpenses()
    fun getExpensesByPeriod(periodId: Long): LiveData<List<Expense>> = expenseDao.getExpensesByPeriod(periodId)
    fun getExpensesByStatus(status: ExpenseStatus): LiveData<List<Expense>> = expenseDao.getExpensesByStatus(status)
    suspend fun getExpenseById(id: Long): Expense? = expenseDao.getExpenseById(id)
    suspend fun insertExpense(expense: Expense): Long = expenseDao.insert(expense)
    suspend fun updateExpense(expense: Expense) = expenseDao.update(expense)
    suspend fun deleteExpense(expense: Expense) = expenseDao.delete(expense)
    suspend fun getTotalExpenseByPeriod(periodId: Long): Double = expenseDao.getTotalExpenseByPeriod(periodId) ?: 0.0
    
    // Incomes
    fun getAllIncomes(): LiveData<List<Income>> = incomeDao.getAllIncomes()
    fun getIncomesByPeriod(periodId: Long): LiveData<List<Income>> = incomeDao.getIncomesByPeriod(periodId)
    suspend fun getIncomeById(id: Long): Income? = incomeDao.getIncomeById(id)
    suspend fun insertIncome(income: Income): Long = incomeDao.insert(income)
    suspend fun updateIncome(income: Income) = incomeDao.update(income)
    suspend fun deleteIncome(income: Income) = incomeDao.delete(income)
    suspend fun getTotalIncomeByPeriod(periodId: Long): Double = incomeDao.getTotalIncomeByPeriod(periodId) ?: 0.0
    
    // Categories
    fun getAllCategories(): LiveData<List<Category>> = categoryDao.getAllCategories()
    suspend fun getCategoryById(id: Long): Category? = categoryDao.getCategoryById(id)
    suspend fun insertCategory(category: Category): Long = categoryDao.insert(category)
    suspend fun updateCategory(category: Category) = categoryDao.update(category)
    suspend fun deleteCategory(category: Category) = categoryDao.delete(category)
    
    // Subcategories
    fun getAllSubcategories(): LiveData<List<Subcategory>> = subcategoryDao.getAllSubcategories()
    fun getSubcategoriesByCategory(categoryId: Long): LiveData<List<Subcategory>> = subcategoryDao.getSubcategoriesByCategory(categoryId)
    suspend fun getSubcategoryById(id: Long): Subcategory? = subcategoryDao.getSubcategoryById(id)
    suspend fun insertSubcategory(subcategory: Subcategory): Long = subcategoryDao.insert(subcategory)
    suspend fun updateSubcategory(subcategory: Subcategory) = subcategoryDao.update(subcategory)
    suspend fun deleteSubcategory(subcategory: Subcategory) = subcategoryDao.delete(subcategory)
    
    // Periods
    fun getAllPeriods(): LiveData<List<Period>> = periodDao.getAllPeriods()
    suspend fun getPeriodById(id: Long): Period? = periodDao.getPeriodById(id)
    suspend fun insertPeriod(period: Period): Long = periodDao.insert(period)
    suspend fun updatePeriod(period: Period) = periodDao.update(period)
    suspend fun deletePeriod(period: Period) = periodDao.delete(period)
    suspend fun getPeriodForDate(timestamp: Long): Period? = periodDao.getPeriodForDate(timestamp)
    
    // Clone Period
    suspend fun clonePeriod(sourcePeriodId: Long, newPeriodName: String, startDate: Long, endDate: Long): Long {
        val newPeriodId = insertPeriod(Period(name = newPeriodName, startDate = startDate, endDate = endDate))
        
        // Clone incomes
        val incomes = incomeDao.getIncomesByPeriod(sourcePeriodId).value ?: emptyList()
        val clonedIncomes = incomes.map { it.copy(id = 0, periodId = newPeriodId) }
        incomeDao.insertAll(clonedIncomes)
        
        // Clone expenses
        val expenses = expenseDao.getExpensesByPeriod(sourcePeriodId).value ?: emptyList()
        val clonedExpenses = expenses.map { it.copy(id = 0, periodId = newPeriodId) }
        expenseDao.insertAll(clonedExpenses)
        
        return newPeriodId
    }
}
