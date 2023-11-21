package com.example.thanksbank.ui.theme.model

class FriendRepository(private val friendDao: FriendDao) {

    suspend fun insertFriendData(friendData: FriendUiState) {
        friendDao.insertFriendData(friendData)
    }

    suspend fun getAllFriendData(): List<FriendUiState> {
        return friendDao.getAllFriendData()
    }

    suspend fun getFriendData(id:Int): FriendUiState {
        return friendDao.getFriendData(id)
    }
}