package com.example.healthydiet.about

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.healthydiet.R

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var aboutVp: ViewPager
    lateinit var shareTv: TextView
    lateinit var pointLayout: LinearLayout
    lateinit var viewList //ViewPager的数据源
            : MutableList<View>
    var picIds = intArrayOf(R.mipmap.ab1, R.mipmap.ab2, R.mipmap.ab3, R.mipmap.ab4, R.mipmap.ab5)
    private var adapter: AboutAdapter? = null
    lateinit var pointList //存放显示器小点点的集合
            : MutableList<ImageView>

    @SuppressLint("HandlerLeak")
    var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            if (msg.what == 1) {
//                接收到消息之后，需要使ViewPager页面向下滑动一页
                val currentItem = aboutVp!!.currentItem
                aboutVp!!.currentItem = currentItem + 1
                sendEmptyMessageDelayed(1, 5000)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        aboutVp = findViewById<ViewPager>(R.id.about_vp)
        shareTv = findViewById<TextView>(R.id.about_tv_share)
        pointLayout = findViewById<LinearLayout>(R.id.about_layout_point)
        shareTv.setOnClickListener(this)
        viewList = ArrayList()
        pointList = ArrayList()
        //        初始化ViewPager的页面信息
        for (i in picIds.indices) {
            val view: View = LayoutInflater.from(this).inflate(R.layout.item_aboutvp, null)
            val iv = view.findViewById<ImageView>(R.id.item_aboutvp_iv)
            iv.setImageResource(picIds[i])
            viewList.add(view)
            //            创建指示器内容
            val pointIv = ImageView(this)
            //            在代码中设置控件的宽高和外边距等属性
            val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            lp.setMargins(0, 0, 20, 0)
            //            将布局参数设置给ImageView
            pointIv.layoutParams = lp
            pointIv.setImageResource(R.mipmap.a2)
            pointList.add(pointIv) //添加到集合当中便于统一管理
            pointLayout.addView(pointIv) //添加到布局当中显示出来
        }
        pointList.get(0).setImageResource(R.mipmap.a3) //设置第一个小圆点为选中状态
        //        创建适配器对象
        adapter = AboutAdapter(viewList)
        //        设置适配器
        aboutVp.setAdapter(adapter)
        //        发送切换页面消息
        handler.sendEmptyMessageDelayed(1, 5000)
        //        设置ViewPager页面监听器
        setVPListener()
    }

    private fun setVPListener() {
        /* 设置ViewPager的监听器*/
        aboutVp!!.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                for (i in pointList!!.indices) {
                    pointList!![i].setImageResource(R.mipmap.a2)
                }
                pointList!![position % pointList!!.size].setImageResource(R.mipmap.a3)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    override fun onClick(v: View) {
//        调用系统自带的分享功能
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        val msg = "健康饮食非常的重要，了解饮食各种营养素和热量，摄入正确的食物，让你变得更健康，想要了解更多么，快来下载健康饮食app吧~~"
        intent.putExtra(Intent.EXTRA_TEXT, msg)
        startActivity(Intent.createChooser(intent, "健康饮食分享"))
    }
}