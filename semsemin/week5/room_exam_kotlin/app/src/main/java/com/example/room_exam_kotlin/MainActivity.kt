package com.example.room_exam_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room_exam_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater) //뷰를 객체화?
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries()
            .build()

        binding.resultText.text=db.todoDao().getAll().toString()

        binding.addButton.setOnClickListener {
            db.todoDao().insert(Todo(binding.todoEdit.text.toString()))
            binding.resultText.text = db.todoDao().getAll().toString() //result가 보이게 함
        }
    }
}