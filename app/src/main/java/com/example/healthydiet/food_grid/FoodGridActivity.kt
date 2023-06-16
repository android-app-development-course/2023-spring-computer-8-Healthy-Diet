package com.example.healthydiet.food_grid


import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.healthydiet.R
import com.example.healthydiet.bean.FoodBean
import com.example.healthydiet.bean.FoodUtils.allFoodList

class FoodGridActivity : AppCompatActivity() {
    lateinit var gv: GridView
    var mDatas: List<FoodBean>? = null
    private var adapter: FoodGridAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_grid)
        gv = findViewById<GridView>(R.id.food_grid_gv)
        //        数据源
        mDatas = allFoodList
        //        创建适配器对象
        adapter = FoodGridAdapter(this, mDatas!!)
        //        设置适配器
        gv.setAdapter(adapter)
        setListener()
    }

    private fun setListener() {
        gv!!.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val foodBean = mDatas!![position]
                val intent = Intent(this@FoodGridActivity, FoodDescActivity::class.java)
                intent.putExtra("food", foodBean)
                startActivity(intent)
            }
    }
}