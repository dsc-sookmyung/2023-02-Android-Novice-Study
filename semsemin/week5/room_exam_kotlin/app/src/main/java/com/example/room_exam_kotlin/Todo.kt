package com.example.room_exam_kotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo( //data를 넣어줘야 getter setter toString 재정의를 안해도 됨
    var title: String
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0 //var로 바꾸고 초기값 0
}