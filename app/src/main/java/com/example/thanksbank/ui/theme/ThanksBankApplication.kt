package com.example.thanksbank.ui.theme

import android.app.Application
import com.example.thanksbank.ui.theme.model.FriendRepository
import com.example.thanksbank.ui.theme.model.ThanksBankDatabase

class ThanksBankApplication:Application() {

    private val database by lazy { ThanksBankDatabase.getDatabase(this) }

    val friendRepository by lazy { FriendRepository(database.friendDao()) }

}