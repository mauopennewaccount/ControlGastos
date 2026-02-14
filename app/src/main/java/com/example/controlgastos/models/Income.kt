package com.example.controlgastos.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "incomes",
    foreignKeys = [
        ForeignKey(
            entity = Period::class,
            parentColumns = ["id"],
            childColumns = ["periodId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Income(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val periodId: Long,
    val type: String, // tarjeta, billetera, monedas
    val amount: Double,
    val description: String,
    val date: Long,
    val status: RecordStatus = RecordStatus.PENDIENTE
)
