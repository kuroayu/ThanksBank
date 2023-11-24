package com.example.thanksbank.ui.theme.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thanksbank.ui.theme.model.FriendRepository
import com.example.thanksbank.ui.theme.model.FriendUiState
import kotlinx.coroutines.launch

class AddFriendViewModel(private val friendRepository: FriendRepository) : ViewModel() {

    fun insertFriendName(friendData: FriendUiState) {
        viewModelScope.launch {
            runCatching {
                friendRepository.insertFriendData(
                    FriendUiState(
                        friendName = friendData.friendName,
                        totalThanksPoint = friendData.totalThanksPoint,
                        message = ""
                    )
                )
            }.onFailure {
                //TODO
            }
        }
    }
}

