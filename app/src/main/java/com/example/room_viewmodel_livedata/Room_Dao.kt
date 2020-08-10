package com.example.room_viewmodel_livedata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Room_Dao {

    @Query("SELECT * FROM Room_Entity")
    fun getAll(): LiveData<List<Room_Entity>> //관찰객체 LiveData로 데이터 변경이 일어나면 자동으로 업데이트 시킴

    @Insert
    fun insert(room_entity: Room_Entity) //

    @Delete
    fun delete(room_entity: Room_Entity)
}