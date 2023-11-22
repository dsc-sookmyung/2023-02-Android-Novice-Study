package com.example.recyclerviewkt

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val rvAdapter = ProfileAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater) //뷰를 객체화?
        setContentView(binding.root)

        //val profileList = arrayListOf(


        //)

        //binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) //여기 mainactivity 의 모든 정보(this)를 가져옴, vertical: 세로 방향
        //binding.rvProfile.setHasFixedSize(true) //recylceview 성능개선 방안

        //binding.rvProfile.adapter = rvAdapter  // ProfileAdapter(/*profileList*/) //adpater 드디어! 연결 ->profileList를 어댑터 안으로 집어넣음

        with(binding){ //반복되는 것 묶음 binding, rvProfile, getcontext 로 받음
            with(rvProfile){
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                adapter = rvAdapter
                addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))

            }
        }

        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT
        ) {
            override fun onMove( //아이템 위아래 이동
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPos: Int =
                    viewHolder.bindingAdapterPosition //바뀌는 포지션이라 bindingAdapterPosition
                val toPos: Int = target.bindingAdapterPosition // 더이상 adapterPosition 사용안함.
                rvAdapter.swapData(fromPos, toPos)
                return true

            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                rvAdapter.removeData(viewHolder.layoutPosition) //고정된 뷰홀더 포지션은 레이아웃 포지션
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                val icon: Bitmap
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                    val itemView = viewHolder.itemView
                    val height = (itemView.bottom - itemView.top).toFloat()
                    val width = height / 4
                    val paint = Paint()
                    if (dX < 0) { //왼쪽으로 스와이프 하면 -로 이동
                        paint.color = Color.parseColor("#ff0000") //빨간색
                        val background = RectF( //사각형의 크기
                            itemView.right.toFloat() + dX,
                            itemView.top.toFloat(),
                            itemView.right.toFloat(),
                            itemView.bottom.toFloat()
                        )
                        c.drawRect(background, paint)

                        icon = BitmapFactory.decodeResource(resources,R.drawable.ic_menu_delete)
                        val iconDst = RectF(itemView.right.toFloat() - 3* width, itemView.top.toFloat() + width, itemView.right.toFloat()-width,
                            itemView.bottom.toFloat()- width)
                        c.drawBitmap(icon, null, iconDst, null)
                    }

                }

            super.onChildDraw(
            c,
            recyclerView,
            viewHolder,
            dX,
            dY,
            actionState,
            isCurrentlyActive
            )
            }

        }
        ItemTouchHelper(itemTouchCallback).attachToRecyclerView(binding.rvProfile)

    }
}