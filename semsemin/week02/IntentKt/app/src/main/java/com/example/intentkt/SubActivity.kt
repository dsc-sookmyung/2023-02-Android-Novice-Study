package com.example.intentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkt.databinding.ActivityMainBinding
import com.example.intentkt.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySubBinding.inflate(layoutInflater) //뷰를 객체화?
        setContentView(binding.root)

        if(intent.hasExtra("msg")){ //msg라는 객체를 가지고있다면 중괄호 실행하라
            binding.tvGetMsg.text = intent.getStringExtra("msg") //intent.putExtra("msg",binding.tvSendMsg.text.toString()) 로 인해 get String 사용
            //서브 액티비티의 존재하는 텍스트뷰에다가 HelloWorld가 넘겨져 옴.
        }

    }
}