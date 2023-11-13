package com.example.intentkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding=ActivityMainBinding.inflate(layoutInflater) //뷰를 객체화?
        setContentView(binding.root)

        binding.btnA.setOnClickListener{
            //var: 변수값이 언제든지 변경 될 수 있음.
            //val: 자바에서는 final 값이 변경되지 못하는 변수.

            val intent = Intent(this, SubActivity ::class.java ) //다음 화면으로 이동하기 위한 인텐트 객체 생성
            intent.putExtra("msg",binding.tvSendMsg.text.toString()) // helloWorld라는 텍스트 값을 담은 뒤 msg라는 키로 잠궜다.
            startActivity(intent) // intent에 저장되어 있는 액티비티 쪽으로 이동한다.
            finish() //자기 자신 액티비티를 파괴한다. -> 종료됨
        }





    }
}