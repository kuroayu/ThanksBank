package com.example.thanksbank.ui.theme.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thanksbank.ui.theme.model.ThanksRepository
import com.example.thanksbank.ui.theme.model.ThanksUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThanksListViewModel(private val thanksRepository: ThanksRepository) : ViewModel() {

    private val _thanksData: MutableStateFlow<List<ThanksUiState>> = MutableStateFlow(emptyList())
    val thanksData: StateFlow<List<ThanksUiState>> = _thanksData
    fun init(friendId: Int) {
        viewModelScope.launch {
            _thanksData.value = thanksRepository.getThanksData(friendId)
        }
    }
}