package com.example.intentkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnA.setOnClickListener {
            // var : 변수 값이 언제든지 변경 될 수 있음.
            // val : 자바에서의 final과 동일. 값이 변경 되지 못하는 변수.
            val intent = Intent(this, SubActivity::class.java) // 다음 화면으로 이동하기 위한 인텐트 객체 생성.
            intent.putExtra("msg", binding.tvSendMsg.text.toString()) // HelloWorld 라는 텍스트 값을 담은 뒤 msg라는 키로 잠갔다.
            startActivity(intent) // intent에 저장 되어 있는 액티비티 쪽으로 이동한다.
            finish()              // 자기 자신 액티비티를 파괴한다.
        }
    }
}