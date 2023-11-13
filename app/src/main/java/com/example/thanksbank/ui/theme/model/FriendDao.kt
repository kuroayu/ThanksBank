package com.example.thanksbank.ui.theme.model

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface FriendDao {
    @Insert
    suspend fun insert(friendData:FriendUiState)
}