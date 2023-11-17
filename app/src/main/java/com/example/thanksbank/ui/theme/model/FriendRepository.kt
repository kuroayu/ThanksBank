package com.example.thanksbank.ui.theme.model

class FriendRepository(private val friendDao: FriendDao) {

     suspend fun insertFriendData(friendData: FriendUiState) {
        friendDao.insertFriendData(friendData)
    }

    suspend fun getFriendData():List<FriendUiState>{
        return friendDao.getFriendData()
    }
}