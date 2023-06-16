package com.example.healthydiet.about

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.healthydiet.R
import com.example.healthydiet.databinding.ActivitySettingBinding
import com.example.healthydiet.login.LoginActivity

class SettingActivity : AppCompatActivity() {

//    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_setting)

    }

    fun onClick(view: View) {
        val intent = Intent()
        when (view.id) {
            R.id.btn_logout -> {
                Toast.makeText(this, "登出成功！返回登陆界面", Toast.LENGTH_SHORT).show()
                // 跳转Login页面
                intent.setClass(this, LoginActivity::class.java)
                this.startActivity(intent)
                this.finish()
            }
        }
    }
}