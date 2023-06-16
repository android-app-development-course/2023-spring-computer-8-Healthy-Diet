package com.example.healthydiet.guide

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.healthydiet.HomeMenuActivity
import com.example.healthydiet.R
import com.example.healthydiet.login.LoginActivity

class GuideActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var guideVp: ViewPager
    var tv1: TextView? = null
    var tv2: TextView? = null
    var tv3: TextView? = null
    var guideBtn: Button? = null
    lateinit var viewList //ViewPager的数据源
            : MutableList<View>
    lateinit var numList //表示页码的集合
            : MutableList<TextView?>
    var resId = intArrayOf(R.mipmap.pic_guide1, R.mipmap.pic_guide2, R.mipmap.pic_guide3) //所显示的图片资源数组
    private var adapter: GuideAdapter? = null

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        guideVp = findViewById(R.id.guide_vp)
        tv1 = findViewById(R.id.guide_tv1)
        tv2 = findViewById(R.id.guide_tv2)
        tv3 = findViewById(R.id.guide_tv3)
        guideBtn = findViewById(R.id.guide_btn)
        guideBtn!!.setOnClickListener(this) //设置按钮的监听器
        viewList = ArrayList()
        numList = ArrayList()
        numList.add(tv1)
        numList.add(tv2)
        numList.add(tv3)
        //        初始化ViewPager的页面资源
        for (i in resId.indices) {
            val view: View = LayoutInflater.from(this).inflate(R.layout.item_guide1, null)
            view.setBackgroundResource(resId[i])
            viewList.add(view)
        }
        //        创建适配器对象
        adapter = GuideAdapter(viewList)
        //        设置适配器
        guideVp.setAdapter(adapter)
        tv1!!.setTextColor(Color.RED)
        //        设置ViewPager的监听
        setVPListener()
    }

    private fun setVPListener() {
        guideVp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                for (i in numList!!.indices) {
                    numList!![i]!!.setTextColor(Color.WHITE)
                }
                numList!![position]!!.setTextColor(Color.RED)
                //                在进入到第三个页面时，立即进入的按钮就显示出来，否则不显示
                if (position == 2) {
                    guideBtn!!.visibility = View.VISIBLE
                } else {
                    guideBtn!!.visibility = View.INVISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.guide_btn -> {
                val intent = Intent(this@GuideActivity, LoginActivity::class.java)
                this.startActivity(intent)
                this.finish()
            }
        }
    }
}