package com.example.controlgastos.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.controlgastos.database.AppDatabase
import com.example.controlgastos.database.AppRepository
import com.example.controlgastos.models.*
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: AppRepository
    
    val allCategories: LiveData<List<Category>>
    val allPeriods: LiveData<List<Period>>
    
    init {
        val database = AppDatabase.getDatabase(application)
        repository = AppRepository(database)
        allCategories = repository.allCategories
        allPeriods = repository.allPeriods
    }
    
    // Category operations
    fun insertCategory(category: Category) = viewModelScope.launch {
        repository.insertCategory(category)
    }
    
    fun updateCategory(category: Category) = viewModelScope.launch {
        repository.updateCategory(category)
    }
    
    fun deleteCategory(category: Category) = viewModelScope.launch {
        repository.deleteCategory(category)
    }
    
    // Subcategory operations
    fun getSubcategoriesByCategory(categoryId: Long): LiveData<List<Subcategory>> {
        return repository.getSubcategoriesByCategory(categoryId)
    }
    
    fun insertSubcategory(subcategory: Subcategory) = viewModelScope.launch {
        repository.insertSubcategory(subcategory)
    }
    
    fun updateSubcategory(subcategory: Subcategory) = viewModelScope.launch {
        repository.updateSubcategory(subcategory)
    }
    
    fun deleteSubcategory(subcategory: Subcategory) = viewModelScope.launch {
        repository.deleteSubcategory(subcategory)
    }
    
    // Period operations
    fun insertPeriod(period: Period) = viewModelScope.launch {
        repository.insertPeriod(period)
    }
    
    fun updatePeriod(period: Period) = viewModelScope.launch {
        repository.updatePeriod(period)
    }
    
    fun deletePeriod(period: Period) = viewModelScope.launch {
        repository.deletePeriod(period)
    }
    
    fun clonePeriod(sourcePeriodId: Long, newPeriodName: String, startDate: Long, endDate: Long) = viewModelScope.launch {
        repository.clonePeriod(sourcePeriodId, newPeriodName, startDate, endDate)
    }
    
    // Income operations
    fun getIncomesByPeriod(periodId: Long): LiveData<List<Income>> {
        return repository.getIncomesByPeriod(periodId)
    }
    
    fun insertIncome(income: Income) = viewModelScope.launch {
        repository.insertIncome(income)
    }
    
    fun updateIncome(income: Income) = viewModelScope.launch {
        repository.updateIncome(income)
    }
    
    fun deleteIncome(income: Income) = viewModelScope.launch {
        repository.deleteIncome(income)
    }
    
    fun updateIncomeStatus(id: Long, status: RecordStatus) = viewModelScope.launch {
        repository.updateIncomeStatus(id, status)
    }
    
    // Expense operations
    fun getExpensesByPeriod(periodId: Long): LiveData<List<Expense>> {
        return repository.getExpensesByPeriod(periodId)
    }
    
    fun insertExpense(expense: Expense) = viewModelScope.launch {
        repository.insertExpense(expense)
    }
    
    fun updateExpense(expense: Expense) = viewModelScope.launch {
        repository.updateExpense(expense)
    }
    
    fun deleteExpense(expense: Expense) = viewModelScope.launch {
        repository.deleteExpense(expense)
    }
    
    fun updateExpenseStatus(id: Long, status: RecordStatus) = viewModelScope.launch {
        repository.updateExpenseStatus(id, status)
    }
}
