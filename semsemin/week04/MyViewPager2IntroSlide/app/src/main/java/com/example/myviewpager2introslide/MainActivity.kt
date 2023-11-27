package com.example.myviewpager2introslide

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.myviewpager2introslide.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

//바인딩으로 요소를 슬라이드 -> 홈, 랭킹, 사용자 버튼 변환은 메인 프레임(백그라운드 투명) 추가 후 이후 위에  add로 교체해서 화면전환

//onNavigationItemSelectedListener 없어짐
class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
     //멤버변수 선언
    private lateinit var homeFragement: HomeFragement
    private lateinit var rankingFragemnt: RankingFragemnt
    private var profileFragemnt: ProfileFragemnt? = null

    companion object {
        const val TAG : String = "로그"
    } //상수처리
    //데이터 배열 준비
    private var pageItemList = ArrayList<PageItem>()
    private lateinit var myIntroPagerRecyclerAdapter: MyIntroPagerRecyclerAdapter

    private lateinit var binding : ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.R)
    //메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater) //뷰를 객체화?
        setContentView(binding.root)

        Log.d(TAG, "MainActivity - onCreate() called")
//setOnNavigationItemselectedListener 없어짐
        binding.bottomNav.setOnItemSelectedListener(this)

        //homeFragement = HomeFragement.newInstance()
        // supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragement).commit() //replace로 프레그먼트 교체

        binding.previousBtn.setOnClickListener{
            Log.d(TAG, "MainActivity - 이전 버튼 클릭")

            binding.myIntroViewPager.currentItem = binding.myIntroViewPager.currentItem - 1
        }
        binding.nextBtn.setOnClickListener{
            Log.d(TAG, "MainACtivity - 다음 버튼 클릭")

            binding.myIntroViewPager.currentItem = binding.myIntroViewPager.currentItem + 1
        }

        window.insetsController?.hide(WindowInsets.Type.statusBars())

        actionBar?.hide()


        //데이터 배열을 준비
        pageItemList.add(
            PageItem(R.color.colorOrange, R.drawable.ic_pager_item_1, "안녕하세요!\n"+"홍세민입니다!"))
        pageItemList.add(
            PageItem(R.color.colorBlue, R.drawable.ic_pager_item_2, "강아지는 귀엽다"))
        pageItemList.add(
            PageItem(R.color.colorWhite, R.drawable.ic_pager_item_3, "강아지는 매우 귀엽다.."))
        //어답터 인스턴스 생성
        myIntroPagerRecyclerAdapter = MyIntroPagerRecyclerAdapter(pageItemList)
        binding.myIntroViewPager.apply{
            adapter = myIntroPagerRecyclerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            binding.dotsIndicator.attachTo(this) //this 자체가 뷰페이저2이므로
        }

 /*       binding.myIntroViewPager.adapter = myIntroPagerRecyclerAdapter
        binding.myIntroViewPager.orientation=ViewPager2.ORIENTATION_HORIZONTAL ===> 이 두줄을 줄이기 위해 apply 적용*/
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "MainActivity - onNavigationItemSelected() called")
        //when이 코틀린에서 스위치문
        when(item.itemId){
            R.id.menu_home -> {
                Log.d(TAG, "MainActivity - 홈버튼 클릭!")
                homeFragement = HomeFragement.newInstance()
                supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragement).commit() //replace로 프레그먼트 교체
            }
            R.id.menu_ranking -> {
                Log.d(TAG, "MainActivity - 랭킹버튼 클릭!")

                rankingFragemnt = RankingFragemnt.newInstance()
                supportFragmentManager.beginTransaction().add(R.id.fragments_frame/*R.id.fragments_frame*/, rankingFragemnt).commit() //replace로 프레그먼트 교체
            }
            R.id.menu_profile -> {
                Log.d(TAG, "MainActivity - 프로필버튼 클릭!")
                profileFragemnt = ProfileFragemnt.newInstance()
                supportFragmentManager.beginTransaction().add(R.id.fragments_frame,
                    profileFragemnt!!
                ).commit() //replace로 프레그먼트 교체
            }
        }

        return true
    }


}