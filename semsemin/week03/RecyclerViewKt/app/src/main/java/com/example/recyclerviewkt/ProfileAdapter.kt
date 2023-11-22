package com.example.recyclerviewkt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections


class ProfileAdapter /*(private val profileList: ArrayList<profiles>)*/ : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>()
{
    private val profileList: ArrayList<profiles> = arrayListOf<profiles>().apply {
        add(profiles(R.drawable.man,"홍드로이드",22,"안드로이드 앱 개발자"));
        add(profiles(R.drawable.woman,"홍드로이드",22,"아이폰 앱 개발자"));
        add(profiles(R.drawable.man,"홍드로이드",22,"리액트 웹 개발자"));
        add(profiles(R.drawable.woman,"홍드로이드",22,"플러터 앱 개발자"));
        add(profiles(R.drawable.man,"홍드로이드",22,"유니티 앱 개발자"));
        add(profiles(R.drawable.woman,"홍드로이드",22,"알고리즘 앱 개발자"));
        add(profiles(R.drawable.woman,"홍드로이드",22,"웹 앱 개발자"));
        add(profiles(R.drawable.man,"홍드로이드",22,"하이브리드 웹 개발자"));
        add(profiles(R.drawable.woman,"홍드로이드",22,"그냥 앱 개발자"));
        add(profiles(R.drawable.woman,"홍드로이드",22,"배고픈 앱 개발자"));
        add(profiles(R.drawable.man,"홍드로이드",22,"졸린 앱 개발자"));
    }

    fun removeData(position: Int){
        profileList.removeAt(position)
        notifyItemRemoved(position)
    }
    fun swapData(fromPos: Int, toPos: Int){
        Collections.swap(profileList, fromPos, toPos)
        notifyItemMoved(fromPos, toPos)
    }
    fun setData(position: Int){
        profileList[position] = profiles(R.drawable.dog,"I love",15, "my dog") //gender int형에 단순  1을 넣어서 리소스를 찾지 못하고 있어서 오류가 났다..다른 리소스를 넣으니 해결됨
        notifyItemChanged(position)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false) //뷰연동: LayoutInflater는 XML에 정의된 Resource를 View 객체로 반환해주는 역할
        //context (액티비티의 정보)를 가져와서 layoutinflater에 적용시킨다. 이후 inflate를 통해 list_item.xml를 붙여준다.
        return CustomViewHolder(view).apply{
            itemView.setOnClickListener {
                val curPos : Int = bindingAdapterPosition
                val profile: profiles = profileList[curPos]
                Toast.makeText(parent.context,"이름 : ${profile.name}\n 나이: ${profile.age} 직업: ${profile.job}", Toast.LENGTH_SHORT).show()
                setData(layoutPosition)
            } //itemview는 viewholder에 가지고 있는 view를 의미
        }

    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        //oncreateviewholder를 실제로 바인딩한다, 스크롤할때, 리스트뷰를 사용할때 onBindViewholder가 지속적으로 호출 view에 대해 안정적으로 데이터들을 매치시켜주는 곳
        holder.gender.setImageResource(profileList[position].gender)
        holder.name.text = profileList.get(position).name //positon은 완성했을 때 위치 (0~), 바인드뷰마다 position 별로 연동시켜줌
        holder.age.text = profileList.get(position).age.toString() //나이는 int라 settext바로 못함, toString으로 문자열 형태로 변환해야함.
        holder.job.text = profileList.get(position).job

    }

    override fun getItemCount(): Int {
        return profileList.size //profilelist의 총길이 리턴

    }


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { //변수들에 할당 - bindviewholder에서 쓸려고
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile) //성별
        val name = itemView.findViewById<TextView>(R.id.tv_name) //이름
        val age = itemView.findViewById<TextView>(R.id.tv_age) //나이
        val job = itemView.findViewById<TextView>(R.id.tv_job) //직업
        //val rv = itemView.findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.vhLayout)


    }


}