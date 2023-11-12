package com.example.intentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkt.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private var mBinding: ActivitySubBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("msg")) {
            binding.tvGetMsg.text = intent.getStringExtra("msg") // 서브 액티비티에 존재하는 텍스트뷰에다가 Hello World가 넘겨져 옴.
        }
    }
}