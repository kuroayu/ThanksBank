package com.example.thanksbank.ui.theme.model

class FriendRepository(private val friendDao: FriendDao) {

    suspend fun insert(friendData: FriendUiState) {
        friendDao.insert(friendData)
    }
}