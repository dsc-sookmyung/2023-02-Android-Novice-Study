package com.example.myviewpager2introslide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyIntroPagerRecyclerAdapter(private var pageList: ArrayList<PageItem>)
    : RecyclerView.Adapter<MyPagerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPagerViewHolder {
        return MyPagerViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.layout_intro_pager_item, parent ,false)) //xml, viewgroup,

    }

    override fun getItemCount(): Int {
        return pageList.size
    }

    override fun onBindViewHolder(holder: MyPagerViewHolder, position: Int) { //화면 넘길때마다 호출됨
        //넘어온 데이터랑 뷰랑 서로 연결, 데이터랑 뷰를 묶는다.
        holder.bindWithView(pageList[position])
    }


}