package com.example.sharedpreferencebasic

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferencebasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater) //뷰를 객체화?
        setContentView(binding.root)
//sharedpreferece 조작하는 것 정의 ->함수로
        binding.buttonSave.setOnClickListener {
            savePref()

        }
        binding.buttonLoad.setOnClickListener {
            loadPref()
        }
    }

    private fun savePref(){
        val sharedPreferences = getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE) //sharedpref 에 핸들러 받아옴, mode_private: 이 앱에서만 사용가능
        val editor = sharedPreferences.edit() //editor라는 인스턴스 -> 하나씩 저장

        editor.putInt(KEY_GRAPHIC, binding.radioGraphics.checkedRadioButtonId)
        editor.putInt(KEY_MUSIC, binding.seekBarMusic.progress)
        editor.putInt(KEY_SFX, binding.seekBarSfx.progress)
        editor.putBoolean(KEY_VSYNK, binding.switchVsync.isChecked) // ischecked 의 true false->boolean editor에 boolean형태로 넣음

        editor.apply()
        Toast.makeText(applicationContext, "Game settings has saved", Toast.LENGTH_SHORT).show()
    }
    private fun loadPref(){
        val sharedPreferences = getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE) //핸들러 가져옴
        if(sharedPreferences.contains(KEY_GRAPHIC)){ //sharedpreferences 안에 key값이 있는지 -> put했던 것 get으로 가져와서 value에 넣음
            val graphicValue = sharedPreferences.getInt(KEY_GRAPHIC, 0) //defaultvalue는 값이 없을 경우, 하지만 이미 if문으로 걸렀기 때문에 의미가 없음
            val musicValue = sharedPreferences.getInt(KEY_MUSIC, 50)
            val sfxValue = sharedPreferences.getInt(KEY_SFX, 50)
            val vsyncValue = sharedPreferences.getBoolean(KEY_VSYNK, true)
            //property들로 값 반영
            binding.radioGraphics.check(graphicValue)
            binding.seekBarMusic.progress = musicValue
            binding.seekBarSfx.progress = sfxValue
            binding.switchVsync.isChecked = vsyncValue
            //반영이 잘되었는지 toast로 확인
            Toast.makeText(applicationContext, "Game setting has loaded", Toast.LENGTH_SHORT).show()
        }
    }
    companion object{
        private const val KEY_PREFS = "game_settings"
        private const val KEY_GRAPHIC = "graphic_quality"
        private const val KEY_MUSIC = "music_volume"
        private const val KEY_SFX = "sfx_volume"
        private const val KEY_VSYNK = "vertical sync"
    }

}