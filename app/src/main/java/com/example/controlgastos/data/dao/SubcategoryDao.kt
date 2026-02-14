package com.example.controlgastos.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlgastos.data.entities.Subcategory

@Dao
interface SubcategoryDao {
    @Query("SELECT * FROM subcategories ORDER BY name ASC")
    fun getAllSubcategories(): LiveData<List<Subcategory>>
    
    @Query("SELECT * FROM subcategories WHERE categoryId = :categoryId ORDER BY name ASC")
    fun getSubcategoriesByCategory(categoryId: Long): LiveData<List<Subcategory>>
    
    @Query("SELECT * FROM subcategories WHERE id = :id")
    suspend fun getSubcategoryById(id: Long): Subcategory?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(subcategory: Subcategory): Long
    
    @Update
    suspend fun update(subcategory: Subcategory)
    
    @Delete
    suspend fun delete(subcategory: Subcategory)
    
    @Query("DELETE FROM subcategories WHERE id = :id")
    suspend fun deleteById(id: Long)
}
