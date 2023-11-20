package com.example.recyclerviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding : ActivityMainBinding ?= null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val profileList = arrayListOf(
            Profiles(R.drawable.man, "현우", 32, "리더"),
            Profiles(R.drawable.man, "민혁", 31, "서브보컬"),
            Profiles(R.drawable.man, "기현", 31, "메인보컬"),
            Profiles(R.drawable.man, "형원", 31, "리드댄서"),
            Profiles(R.drawable.man, "주헌", 30, "메인래퍼"),
            Profiles(R.drawable.man, "창균", 28, "리드래퍼"),

            Profiles(R.drawable.woman, "아이린", 33, "리더"),
            Profiles(R.drawable.woman, "슬기", 30, "메인댄서"),
            Profiles(R.drawable.woman, "웬디", 30, "메인보컬"),
            Profiles(R.drawable.woman, "조이", 28, "서브보컬"),
            Profiles(R.drawable.woman, "예리", 25, "리드래퍼")
        )

        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProfile.setHasFixedSize(true)

        binding.rvProfile.adapter = ProfileAdapter(profileList)
    }
}