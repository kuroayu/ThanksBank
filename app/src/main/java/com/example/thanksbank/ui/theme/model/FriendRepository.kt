package com.example.thanksbank.ui.theme.model

class FriendRepository(private val thanksBankDao: ThanksBankDao) {

    suspend fun insertFriendData(friendData: FriendUiState) {
        thanksBankDao.insertFriendData(friendData)
    }

    suspend fun getAllFriendData(): List<FriendUiState> {
        return thanksBankDao.getAllFriendData()
    }
}