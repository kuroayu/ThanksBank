package com.example.thanksbank.ui.theme.model

class ThanksRepository(private val thanksBankDao: ThanksBankDao) {

    suspend fun insertThanksData(thanksData: ThanksUiState) {
        thanksBankDao.insertThanksData(thanksData)
    }

    suspend fun getThanksData(friendId: Int): List<ThanksUiState> {
        return thanksBankDao.getThanksData(friendId)
    }
}