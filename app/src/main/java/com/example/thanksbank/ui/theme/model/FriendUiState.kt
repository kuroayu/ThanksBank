package com.example.thanksbank.ui.theme.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "friend")
data class FriendUiState(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val friendName: String,
    val totalThanksPoint: Int = 0,
    val message: String
)
