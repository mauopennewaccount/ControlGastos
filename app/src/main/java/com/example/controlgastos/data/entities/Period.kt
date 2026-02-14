package com.example.controlgastos.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "periods")
data class Period(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val startDate: Long,
    val endDate: Long,
    val createdAt: Long = System.currentTimeMillis()
)
