package com.example.thanksbank.ui.theme.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime


@Entity(tableName = "friend")
data class FriendUiState(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val friendName: String,
    val createAt:Long,
    val totalThanksPoint: Int
)
