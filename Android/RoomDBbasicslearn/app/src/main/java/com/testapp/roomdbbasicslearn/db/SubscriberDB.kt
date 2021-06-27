package com.testapp.roomdbbasicslearn.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.testapp.roomdbbasicslearn.models.Subscriber

@Database(entities = [Subscriber::class], version = 1)
abstract class SubscriberDB : RoomDatabase() {
    abstract val subscriberDao:SubscriberDao

    companion object {
        @Volatile
        private var INSTANCE : SubscriberDB? = null

        fun getInstance(context: Context) : SubscriberDB {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SubscriberDB::class.java,
                    "subscribers_data"
                ).build()
            }
        }
    }
}