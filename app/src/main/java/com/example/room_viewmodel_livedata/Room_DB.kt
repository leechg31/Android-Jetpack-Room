package com.example.room_viewmodel_livedata

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Room_Entity::class], version = 1)
abstract class Room_DB : RoomDatabase() {

    abstract fun Room_Dao(): Room_Dao
}