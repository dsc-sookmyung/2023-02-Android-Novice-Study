package com.example.fragmentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fragmentkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater) //뷰를 객체화?
        setContentView(binding.root)

        setFrag(0)
        binding.btnFragment1.setOnClickListener{
            setFrag(0)
    }
        binding.btnFragment2.setOnClickListener{
            setFrag(1)
        }


        binding.btnFragment3.setOnClickListener{
            setFrag(2)
    }

    }

    private fun setFrag(fragNum : Int) {
        val ft = supportFragmentManager.beginTransaction()
        when(fragNum){
            0 -> {
                ft.replace(R.id.main_frame, Frament1()).commit() //mainframe에 frament1을 넣고 저장(commit)해라

            }
            1 -> {
                ft.replace(R.id.main_frame, Frament2()).commit()


            }
            2 -> {
                ft.replace(R.id.main_frame, Frament3()).commit()

            }
        }

    }
}