package com.example.thanksbank.ui.theme.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FriendUiState::class], version = 1, exportSchema = false)
abstract class ThanksBankDatabase : RoomDatabase() {
    abstract fun friendDao(): FriendDao

    companion object {
        private var INSTANCE: ThanksBankDatabase? = null

        fun getDatabase(
            context: Context
        ): ThanksBankDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ThanksBankDatabase::class.java,
                        "ThanksBank.db"
                    )
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}