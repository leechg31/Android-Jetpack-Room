package com.example.room_viewmodel_livedata

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Room_Entity(//data를 붙혀야지 getter setter 재정의 안해도 알아서 되게 해줌
    var title: String
)//getter setter은 내부적으로 생성해 줌. 코틀린은 기본 scope가 public임. val은 getter만 만들어지고 var은 setter getter 다 만들어짐.
{
    @PrimaryKey(autoGenerate = true) var id : Int = 0

    override fun toString(): String {
        return id.toString() + "번째 title : " + title + "\n"
    }
}