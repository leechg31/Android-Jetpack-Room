package com.example.room_viewmodel_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            Room_DB::class.java, "database-name"
        )
            //.allowMainThreadQueries()//UI Thread에서 DB처리 하게해준다. 그러나 성능을 저하시키므로 Background Thread에서 비동기로 DB를 처리해야 함
            .build()

        db.Room_Dao().getAll().observe(this, Observer {
            result_text.text = it.toString()
        })

        add_button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {//코틀린에서는 코루틴 방식으로 AsyncTask를 사용하지않고 쉽게 BackgroundTask에서 돌아가게한다
                db.Room_Dao().insert(Room_Entity(name_edittext.text.toString()))
            }
        }

    }
}