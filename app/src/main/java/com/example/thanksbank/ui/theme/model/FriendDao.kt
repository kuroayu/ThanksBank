package com.example.thanksbank.ui.theme.model

import androidx.room.*
import com.example.thanksbank.ui.theme.ui.FriendsData

@Dao
interface FriendDao {
    @Insert
    suspend fun insertFriendData(friendData:FriendUiState)

    @Query("SELECT * FROM friend ORDER BY friendName")
    suspend fun getAllFriendData():List<FriendUiState>
    @Query("SELECT * FROM friend WHERE id == (:id) ")
    suspend fun getFriendData(id:Int):FriendUiState
}