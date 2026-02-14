package com.example.controlgastos.database

import androidx.room.TypeConverter
import com.example.controlgastos.models.RecordStatus

class Converters {
    @TypeConverter
    fun fromRecordStatus(value: RecordStatus): String {
        return value.name
    }

    @TypeConverter
    fun toRecordStatus(value: String): RecordStatus {
        return RecordStatus.valueOf(value)
    }
}
