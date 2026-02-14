package com.example.controlgastos.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

enum class ExpenseStatus {
    PENDING, PAID, INACTIVE
}

@Entity(
    tableName = "expenses",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = Subcategory::class,
            parentColumns = ["id"],
            childColumns = ["subcategoryId"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = Period::class,
            parentColumns = ["id"],
            childColumns = ["periodId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("categoryId"), Index("subcategoryId"), Index("periodId")]
)
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val categoryId: Long?,
    val subcategoryId: Long?,
    val description: String,
    val amount: Double,
    val additionalDescription: String = "",
    val status: ExpenseStatus,
    val date: Long,
    val periodId: Long,
    val createdAt: Long = System.currentTimeMillis()
)
