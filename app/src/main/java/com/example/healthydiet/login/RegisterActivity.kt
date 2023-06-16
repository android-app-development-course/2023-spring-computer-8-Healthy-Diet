package com.example.healthydiet.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.healthydiet.R
import com.example.healthydiet.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_register)

    }

    fun onClick(view: View) {
        val intent = Intent()
        when (view.id) {
            R.id.btn_register -> {
                val pwd: String = binding.edtPwd.text.toString().trim()
                val confirm: String = binding.edtConfirm.text.toString().trim()

                //进行判断，如果两个内容都相等，就显现第一条语句，反之，第二条。
                if ((pwd == confirm) and (pwd != null)) {
                    Toast.makeText(this, "注册成功,返回登陆界面", Toast.LENGTH_SHORT).show()
                    // 跳转Login页面
                    intent.setClass(this, LoginActivity::class.java)
                    this.startActivity(intent)
                    this.finish()
                } else {
                    Toast.makeText(this, "两次输入密码不一致！或信息未填写完全", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}