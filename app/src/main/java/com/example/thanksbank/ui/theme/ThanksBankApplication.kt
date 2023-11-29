package com.example.thanksbank.ui.theme

import android.app.Application
import com.example.thanksbank.ui.theme.model.FriendRepository
import com.example.thanksbank.ui.theme.model.ThanksBankDatabase
import com.example.thanksbank.ui.theme.model.ThanksRepository

class ThanksBankApplication:Application() {

    private val database by lazy { ThanksBankDatabase.getDatabase(this) }

    val friendRepository by lazy { FriendRepository(database.friendDao()) }

    val thanksRepository by lazy { ThanksRepository(database.friendDao()) }

}