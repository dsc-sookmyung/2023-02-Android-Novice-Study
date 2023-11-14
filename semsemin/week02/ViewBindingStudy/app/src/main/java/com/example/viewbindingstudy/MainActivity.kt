package com.example.viewbindingstudy

import android.R.attr.button
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.viewbindingstudy.databinding.ActivityMainBinding
import kotlinx.coroutines.newFixedThreadPoolContext


class MainActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //액티비티 바인딩 객체에 할당 및 뷰 설정
        binding=ActivityMainBinding.inflate(layoutInflater) //뷰를 객체화?
        setContentView(binding.root)

        binding.tvHello.setText("홍드로이드 안녕하세요 !")
        binding.btnHello.setOnClickListener { view ->
            Toast.makeText(this, "안녕하세요", Toast.LENGTH_SHORT).show()
        }
//fragment 교체
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.main_frame, TestFragment())
        ft.commit()

    }
}