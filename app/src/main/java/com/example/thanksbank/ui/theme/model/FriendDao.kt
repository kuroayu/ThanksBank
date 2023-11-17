package com.example.thanksbank.ui.theme.model

import androidx.room.*

@Dao
interface FriendDao {
    @Insert
    suspend fun insertFriendData(friendData:FriendUiState)

    @Query("SELECT * FROM friend ORDER BY friendName")
    suspend fun getFriendData():List<FriendUiState>
}