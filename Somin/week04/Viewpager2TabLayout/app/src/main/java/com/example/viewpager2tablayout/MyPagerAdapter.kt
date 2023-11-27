package com.example.viewpager2tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    // 외부에서 FragmentActivity를 받아와서 그걸 처리.
    private val NUM_PAGES = 3

    override fun getItemCount(): Int = NUM_PAGES
    // 만들어줄 전체 페이지 수

    override fun createFragment(position: Int): Fragment {
        // 각 페이지가 어떤 프래그먼트로 만들어질지 내용 전해줌.
        return when (position) {
            0 -> { MyFragment.newInstance("Page 1", "")}
            1 -> { MyFragment.newInstance("Page 2", "")}
            else -> { MyFragment.newInstance("Page 3", "")}
        }
    }
}