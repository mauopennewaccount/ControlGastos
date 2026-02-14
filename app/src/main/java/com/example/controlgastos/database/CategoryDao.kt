package com.example.controlgastos.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlgastos.models.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM categories ORDER BY name ASC")
    fun getAllCategories(): LiveData<List<Category>>
    
    @Query("SELECT * FROM categories WHERE id = :id")
    suspend fun getCategoryById(id: Long): Category?
    
    @Insert
    suspend fun insert(category: Category): Long
    
    @Update
    suspend fun update(category: Category)
    
    @Delete
    suspend fun delete(category: Category)
}
