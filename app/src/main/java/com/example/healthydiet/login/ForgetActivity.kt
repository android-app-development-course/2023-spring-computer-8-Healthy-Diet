package com.example.healthydiet.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.healthydiet.R
import com.example.healthydiet.databinding.ActivityForgetBinding

class ForgetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_forget)
    }

    fun onClick(v: View) {
        val intent = Intent()
        when (v.id) {
            R.id.btn_send -> {
                val email: String = binding.etEmail.text.toString().trim()
                val newpwd: String = binding.etNewpwd.text.toString().trim()
                val confirpwd: String = binding.etConfirmpwd.text.toString().trim()

                //进行判断，如果两个内容都相等，就显现第一条语句，反之，第二条。
                if (newpwd == confirpwd) {
                    Toast.makeText(this, "重置成功,返回登陆界面", Toast.LENGTH_SHORT).show()
                    // 跳转Login页面
                    intent.setClass(this, LoginActivity::class.java)
                    this.startActivity(intent)
                    this.finish()
                } else {
                    Toast.makeText(this, "两次输入密码不一致！", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}