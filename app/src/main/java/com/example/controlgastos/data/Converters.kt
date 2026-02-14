package com.example.controlgastos.data

import androidx.room.TypeConverter
import com.example.controlgastos.data.entities.ExpenseStatus
import com.example.controlgastos.data.entities.IncomeType

class Converters {
    @TypeConverter
    fun fromIncomeType(type: IncomeType): String {
        return type.name
    }
    
    @TypeConverter
    fun toIncomeType(value: String): IncomeType {
        return IncomeType.valueOf(value)
    }
    
    @TypeConverter
    fun fromExpenseStatus(status: ExpenseStatus): String {
        return status.name
    }
    
    @TypeConverter
    fun toExpenseStatus(value: String): ExpenseStatus {
        return ExpenseStatus.valueOf(value)
    }
}
