package com.example.controlgastos.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

enum class IncomeType {
    CARD, WALLET, COINS
}

@Entity(
    tableName = "incomes",
    foreignKeys = [
        ForeignKey(
            entity = Period::class,
            parentColumns = ["id"],
            childColumns = ["periodId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("periodId")]
)
data class Income(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val type: IncomeType,
    val amount: Double,
    val description: String = "",
    val date: Long,
    val periodId: Long,
    val createdAt: Long = System.currentTimeMillis()
)
