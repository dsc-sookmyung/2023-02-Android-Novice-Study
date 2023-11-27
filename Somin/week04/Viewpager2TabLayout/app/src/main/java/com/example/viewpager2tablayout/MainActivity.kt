package com.example.viewpager2tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.viewpager2tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tabIcon = listOf(
        R.drawable.ic_baseline_format_list_bulleted_24,
        R.drawable.ic_baseline_map_24,
        R.drawable.ic_baseline_info_24
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 어뎁터 설정
        binding.viewpager.apply {
            adapter = MyPagerAdapter(context as FragmentActivity)
            // MyPagerAdapter 객체 만들어서 뷰페이저 어뎁터 속성에 연결

            setPageTransformer(ZoomOutPageTransformer())
        }

        // 탭 레이아웃과 뷰페이저2를 연결할 때 TabLayoutMediator 씀.
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            tab.text = "Title $position"
            tab.setIcon(tabIcon[position]) // 포지션에 따라 서로 다른 아이콘을 가져오도록, 탭에 아이콘을 지정하기 위해 setIcon 함수 이용.
        }.attach()
    }
}