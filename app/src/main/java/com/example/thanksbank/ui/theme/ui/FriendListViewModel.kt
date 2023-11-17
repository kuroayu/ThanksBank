package com.example.thanksbank.ui.theme.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thanksbank.ui.theme.model.FriendRepository
import com.example.thanksbank.ui.theme.model.FriendUiState
import kotlinx.coroutines.launch

class FriendListViewModel(private val friendRepository: FriendRepository):ViewModel() {
    fun getFriendData():List<FriendUiState>{
        var friendData = emptyList<FriendUiState>()
        viewModelScope.launch {
            friendData = friendRepository.getFriendData()
        }
        return friendData
    }
}