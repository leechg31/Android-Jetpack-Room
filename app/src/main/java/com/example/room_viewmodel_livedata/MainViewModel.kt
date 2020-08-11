package com.example.room_viewmodel_livedata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        Room_DB::class.java, "Room-DB"
    )
        //.allowMainThreadQueries()//UI Thread에서 DB처리 하게해준다. 그러나 성능을 저하시키므로 Background Thread에서 비동기로 DB를 처리해야 함
        .build()

    var rooms: LiveData<List<Room_Entity>>

    init {
        rooms = getAll()
    }

    var newRooms: String? = null

    fun getAll(): LiveData<List<Room_Entity>> {
        return db.Room_Dao().getAll()
    }

    fun insert(Re: String) {//suspend:코루틴 안에 존재해야 하게 만듦
        viewModelScope.launch(Dispatchers.IO) {
            db.Room_Dao().insert(Room_Entity(Re))
        }
    }
}