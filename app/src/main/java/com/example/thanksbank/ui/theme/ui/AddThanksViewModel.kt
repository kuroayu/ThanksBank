package com.example.thanksbank.ui.theme.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thanksbank.ui.theme.model.ThanksRepository
import kotlinx.coroutines.launch

class AddThanksViewModel(private val thanksRepository: ThanksRepository):ViewModel() {

    fun insertThanksData(){
        viewModelScope.launch {
            runCatching {
                thanksRepository.insertThanksData(
                    //TODO
                )
            }.onFailure {
                //TODO
            }
        }

    }
}