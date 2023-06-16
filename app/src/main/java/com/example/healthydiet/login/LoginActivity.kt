package com.example.healthydiet.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.healthydiet.HomeMenuActivity
import com.example.healthydiet.R


class LoginActivity : AppCompatActivity() {
    lateinit var name: EditText  //创建账号
    lateinit var passwd : EditText //创建密码

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        name = findViewById(R.id.et_username) //获取输入的账号
        passwd = findViewById(R.id.et_psw) //获取输入的密码
    }

    //添加按钮事件
    fun onClick(v: View) {
        val intent = Intent()
        when (v.id) {
            R.id.btn_login -> {
                //这是能够登录的账号密码
                val Uname = "admin"
                val Upwd = "12345"

                //创建两个String类，储存从输入文本框获取到的内容
                val user: String = name.getText().toString().trim()
                val pwd: String = passwd.getText().toString().trim()

                //进行判断，如果两个内容都相等，就显现第一条语句，反之，第二条。
                if ((user == Uname) and (pwd == Upwd)) {
                    Toast.makeText(this, "欢迎你！", Toast.LENGTH_SHORT).show()

                    // 跳转主页面
                    intent.setClass(this@LoginActivity, HomeMenuActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "账号或密码错误！", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.btn_register -> {
                intent.setClass(this@LoginActivity, RegisterActivity::class.java);
                this.startActivity(intent);
            }
            R.id.btn_forget -> {
                intent.setClass(this@LoginActivity, ForgetActivity::class.java);
                this.startActivity(intent);
            }
        }

    }

}