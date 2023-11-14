package com.example.fragmentkt

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentkt.databinding.Frag2Binding
import com.example.fragmentkt.databinding.Frag3Binding

class Frament3 : Fragment() {
    private var mBinding: Frag3Binding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = Frag3Binding.inflate(inflater, container, false) //setcontantview 와 같음 (fragment 버전)

        return binding.root
    }
}