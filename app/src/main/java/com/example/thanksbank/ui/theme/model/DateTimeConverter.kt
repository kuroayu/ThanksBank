package com.example.thanksbank.ui.theme.model

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.util.Date

class DateTimeConverter {

    @TypeConverter
    fun fromTimestamp(value: S?):LocalDateTime?{
        return if (value == null) null else LocalDateTime(value)
    }

}