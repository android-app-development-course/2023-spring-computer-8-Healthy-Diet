package com.example.healthydiet

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.healthydiet.R
import com.example.healthydiet.about.AboutActivity
import com.example.healthydiet.about.SettingActivity
import com.example.healthydiet.food_grid.FoodGridActivity
import com.example.healthydiet.food_list.InfoListActivity

class HomeMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_menu)
    }

    fun onClick(view: View) {
        val intent = Intent()
        when (view.id) {
            R.id.home_btn1 -> {
                intent.setClass(this@HomeMenuActivity, InfoListActivity::class.java)
            }
            R.id.home_btn2 -> {
                intent.setClass(this@HomeMenuActivity, FoodGridActivity::class.java)
            }
            R.id.btn_about -> {
                intent.setClass(this@HomeMenuActivity, AboutActivity::class.java)
            }
            R.id.btn_setting -> {
                intent.setClass(this@HomeMenuActivity, SettingActivity::class.java)
            }
        }
        startActivity(intent)
    }
}
