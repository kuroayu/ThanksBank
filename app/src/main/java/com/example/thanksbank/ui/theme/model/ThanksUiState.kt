package com.example.thanksbank.ui.theme.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "thanks")
data class ThanksUiState(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val friendId: String,
    val date: Long,
    val thanksPoint: Int,
    val message: String
)
