package com.example.thanksbank.ui.theme.model

import androidx.room.*

@Dao
interface ThanksBankDao {
    @Insert
    suspend fun insertFriendData(friendData: FriendUiState)

    @Insert
    suspend fun insertThanksData(thanksData: ThanksUiState)

    @Query("SELECT * FROM friend ORDER BY friendName")
    suspend fun getAllFriendData(): List<FriendUiState>

    @Query("SELECT * FROM thanks WHERE friendId == (:friendId) ORDER BY date")
    suspend fun getThanksData(friendId: Int): List<ThanksUiState>
}