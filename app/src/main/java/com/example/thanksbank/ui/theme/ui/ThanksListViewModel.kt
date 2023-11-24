package com.example.thanksbank.ui.theme.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thanksbank.ui.theme.model.FriendRepository
import com.example.thanksbank.ui.theme.model.FriendUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThanksListViewModel(private val friendRepository: FriendRepository) : ViewModel() {

    private val _friendData: MutableStateFlow<FriendUiState?> = MutableStateFlow(null)
    val friendData: StateFlow<FriendUiState?> = _friendData
    fun init(friendId: Int) {
        viewModelScope.launch {
            _friendData.value = friendRepository.getFriendData(friendId)
        }
    }
}