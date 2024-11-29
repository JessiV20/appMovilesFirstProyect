package com.example.myfirstapplication.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myfirstapplication.data.model.ServiceEntity
import com.example.myfirstapplication.data.model.dao.ServiceDao


@Database(entities = [ServiceEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun serviceDao(): ServiceDao
}
