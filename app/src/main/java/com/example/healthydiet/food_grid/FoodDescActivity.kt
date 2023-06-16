package com.example.healthydiet.food_grid

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.healthydiet.R
import com.example.healthydiet.bean.FoodBean

class FoodDescActivity : AppCompatActivity() {
    lateinit var titleTv1: TextView
    lateinit var titleTv2: TextView
    lateinit var descTv: TextView
    lateinit var notTv: TextView
    var backIv: ImageView? = null
    var bigPicIv: ImageView? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_desc)
        initView()
        //        接受上一级页面传来的数据
        val intent: Intent = getIntent()
        val foodBean: FoodBean? = intent.getSerializableExtra("food") as FoodBean?
        //        设置显示控件
        titleTv1.setText(foodBean!!.title)
        titleTv2.setText(foodBean.title)
        descTv.setText(foodBean.desc)
        notTv.setText(foodBean.notmatch)
        bigPicIv!!.setImageResource(foodBean.picId)
    }

    private fun initView() {
        titleTv1 = findViewById(R.id.fooddesc_tv_title1)
        titleTv2 = findViewById(R.id.fooddesc_tv_title2)
        descTv = findViewById(R.id.fooddesc_tv_desc)
        notTv = findViewById(R.id.fooddesc_tv_not)
        backIv = findViewById(R.id.fooddesc_iv_back)
        bigPicIv = findViewById(R.id.fooddesc_iv_bigpic)
        backIv!!.setOnClickListener {
            finish() //销毁当前的activity
        }
    }
}