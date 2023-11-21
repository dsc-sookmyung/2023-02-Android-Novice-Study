package com.example.listviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding : ActivityMainBinding ?= null
    private val binding get() = mBinding!!

    var UserList = arrayListOf<User>(
        User(R.drawable.android, "현우", "32", "첫째"),
        User(R.drawable.android, "민혁", "31", "둘째"),
        User(R.drawable.android, "기현", "31", "셋째"),
        User(R.drawable.android, "형원", "31", "넷째"),
        User(R.drawable.android, "주헌", "30", "다섯째"),
        User(R.drawable.android, "창균", "28", "막내")
    )

    override fun onCreate(savedInstanceState: Bundle?) { // 액티비티의 실행 시작 지점
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val item = arrayOf("사과", "배", "딸기", "키위", "바나나")
//        // context란 한 액티비티의 모든 정보를 담고 있다.
//        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

        val Adapter = UserAdapter(this, UserList)
        binding.listView.adapter = Adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()

        }
    }
}