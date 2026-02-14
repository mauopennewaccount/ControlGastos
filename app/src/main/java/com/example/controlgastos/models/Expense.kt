package com.example.controlgastos.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "expenses",
    foreignKeys = [
        ForeignKey(
            entity = Period::class,
            parentColumns = ["id"],
            childColumns = ["periodId"],
            onDelete = ForeignKey.CASCADE
        ),
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
        )
    ]
)
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val periodId: Long,
    val categoryId: Long?,
    val subcategoryId: Long?,
    val description: String,
    val amount: Double,
    val additionalDescription: String?,
    val date: Long,
    val status: RecordStatus = RecordStatus.PENDIENTE
)
