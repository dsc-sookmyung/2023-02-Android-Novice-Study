package com.example.myviewpager2introslide

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ProfileFragemnt : Fragment() {
    companion object {
        const val TAG : String = "로그"

        fun newInstance(): ProfileFragemnt{
            return ProfileFragemnt()
        }
    }

//프래그먼트가 메모리에 올라갓을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "ProfileFragemnt - onCreate() called")
    }
    //프레그먼트를 안고 있는 액티비티에 붙였을 때
    override fun onAttach(context: Context){
        super.onAttach(context)
        Log.d(TAG, "ProfileFragemnt - onAttach() called")
    }
    //뷰가 생성되었을 때
    //프레그먼트와 레이아웃을 연결시켜주는 부분이다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "ProfileFragemnt - onCreateView() called")

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        return view
    }
}