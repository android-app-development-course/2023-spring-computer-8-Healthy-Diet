package com.example.healthydiet

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.healthydiet.R
import com.example.healthydiet.guide.GuideActivity
import com.example.healthydiet.login.LoginActivity

class MainActivity : AppCompatActivity() {
    var tv: TextView? = null
    var time = 3 // 倒计时
    var preferences: SharedPreferences? = null //存储键值对数据
    private var editor: SharedPreferences.Editor? = null

    @SuppressLint("HandlerLeak")
    var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            if (msg.what == 1) {
                time--
                if (time == 0) {
                    //  跳转页面
                    val intent = Intent()
                    val isFirst = preferences!!.getBoolean("isfirst", true)
                    if (isFirst) {
                        intent.setClass(this@MainActivity, GuideActivity::class.java)
                        editor!!.putBoolean("isfirst", false) //写入不是第一次进入的纪录
                        editor!!.commit() // 提交本次修改纪录
                    } else {
                        intent.setClass(this@MainActivity, LoginActivity::class.java)
                    }
                    startActivity(intent)
                    finish()
                } else {
                    tv!!.text = time.toString() + ""
                    sendEmptyMessageDelayed(1, 1000)
                }
            }
        }
    }

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.main_tv)
        preferences = getSharedPreferences("health_pref", Context.MODE_PRIVATE)
        editor = preferences!!.edit() //写入数据的对象
        handler.sendEmptyMessageDelayed(1, 1000)
    }
}