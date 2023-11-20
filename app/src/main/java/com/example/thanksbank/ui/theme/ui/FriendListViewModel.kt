package com.example.thanksbank.ui.theme.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thanksbank.ui.theme.model.FriendRepository
import com.example.thanksbank.ui.theme.model.FriendUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FriendListViewModel(private val friendRepository: FriendRepository):ViewModel() {

    private val _friendData: MutableStateFlow<List<FriendUiState>> = MutableStateFlow(emptyList())
    val friendData:StateFlow<List<FriendUiState>> = _friendData

    fun init() {
        viewModelScope.launch {
            _friendData.value = friendRepository.getFriendData()
        }
    }
}