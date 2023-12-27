package com.example.room_exam_kotlin

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll(): List<Todo> //todo에서 모든 값 호출

    @Insert
    fun insert(todo: Todo)

    @Update
    fun  //todo객체 수정한거 업데이트 되도록
            update(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}