package com.example.thanksbank.ui.theme.model

import androidx.room.*

@Dao
interface FriendDao {
    @Insert
    suspend fun insert(friendData:FriendUiState)
}