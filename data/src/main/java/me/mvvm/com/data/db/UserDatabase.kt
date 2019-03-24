package me.mvvm.com.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import me.mvvm.com.data.entities.UserPublisherData

/**
 * Created by Alexander Karpenko on 3/10/19.
 * java.karpenko@gmail.com
 */

@Database(entities = arrayOf(UserPublisherData::class), version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserPropertyDao
}