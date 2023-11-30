package com.example.myviewpager2introslide

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*private lateinit var binding : LayutIntroPagerItemBinding*/
class MyPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


    private val itemImage  = itemView.findViewById<ImageView>(R.id.pager_item_image)
    private val itemContent = itemView.findViewById<TextView>(R.id.pager_item_text)
    private val itemBg = itemView.findViewById<LinearLayout>(R.id.pager_item_bg)

    fun bindWithView(pageItem: PageItem){
        itemImage.setImageResource(pageItem.imageSrc)
        itemContent.text = pageItem.content //텍스트를 바꿔줌
        
        if(pageItem.bgColor != R.color.colorWhite){ //배경이 흰색이 아니라면 글자색이 흰색이 되도록 변경
            itemContent.setTextColor(Color.WHITE)
        }

        itemBg.setBackgroundResource(pageItem.bgColor) //배경색 바꿔줌



    }

}