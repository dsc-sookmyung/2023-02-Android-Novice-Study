package com.example.listviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var UserList = arrayListOf<User>(
        User(R.drawable.android, "홍드로이드","22","안녕하세요"),
        User(R.drawable.android, "자바","22","안녕하세요"),
        User(R.drawable.android, "자바스크립트","22","안녕하세요"),
        User(R.drawable.android, "코틀린","22","안녕하세요"),
        User(R.drawable.android, "스위프트","22","안녕하세요"),
        User(R.drawable.android, "안드로이드","22","안녕하세요"),
        User(R.drawable.android, "리액트 네이티브","22","안녕하세요")
    )
    override fun onCreate(savedInstanceState: Bundle?) { //액티비티의 실행 시작 시점
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater) //뷰를 객체화?
        setContentView(binding.root)

        //val item = arrayOf("사과", "배", "딸기","키위","홍드로이드")
        //context란 한 애티비티의 모든 정보를 담고있다.
        //binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,item)

        val Adapter = UserAdapter(this, UserList)
        binding.listView.adapter = Adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this,selectItem.name, Toast.LENGTH_SHORT).show()

        }

    }
}