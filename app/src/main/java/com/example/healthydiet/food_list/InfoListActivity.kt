package com.example.healthydiet.food_list

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.healthydiet.R
import com.example.healthydiet.bean.FoodBean
import com.example.healthydiet.bean.FoodUtils
import com.example.healthydiet.food_grid.FoodDescActivity

class InfoListActivity : AppCompatActivity(), View.OnClickListener {
    var searchEt: EditText? = null
    lateinit var searchIv: ImageView
    lateinit var flushIv: ImageView
    var showLv: ListView? = null

    //    ListView内部数据源
    lateinit var mDatas: MutableList<FoodBean>
    var allFoodList: List<FoodBean>? = null
    private var adapter: InfoListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_list)
        //        查找控件
        initView()
        //        2.找到ListView对应的数据源
        mDatas = ArrayList()
        allFoodList = FoodUtils.allFoodList
        mDatas.addAll(allFoodList!!)
        //        3.创建适配器  BaseAdapter的子类
        adapter = InfoListAdapter(this, mDatas)
        showLv!!.adapter = adapter //4.设置适配器
        //        设置单向点击监听功能
        setListener()
    }

    private fun setListener() {
        showLv!!.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val foodBean = mDatas!![position]
                val intent = Intent(this@InfoListActivity, FoodDescActivity::class.java)
                intent.putExtra("food", foodBean)
                startActivity(intent)
            }
    }

    private fun initView() {
        searchEt = findViewById<EditText>(R.id.info_et_search)
        searchIv = findViewById<ImageView>(R.id.info_iv_search)
        flushIv = findViewById<ImageView>(R.id.info_iv_flush)
        showLv = findViewById<ListView>(R.id.infolist_lv)
        searchIv.setOnClickListener(this) //添加点击事件的监听器
        flushIv.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.info_iv_flush -> {
                searchEt!!.setText("")
                mDatas!!.clear()
                mDatas!!.addAll(allFoodList!!)
                adapter!!.notifyDataSetChanged()
            }
            R.id.info_iv_search -> {
                //                1.获取输入内容，判断不为空
                val msg = searchEt!!.text.toString().trim { it <= ' ' } //获取输入信息
                if (TextUtils.isEmpty(msg)) {
                    Toast.makeText(this, "输入内容不能为空！", Toast.LENGTH_SHORT).show()
                    return
                }
                //                判断所有食物列表的标题是否包含输入内容，如果包含，就添加到小集合中
                val list: MutableList<FoodBean> = ArrayList()
                var i = 0
                while (i < allFoodList!!.size) {
                    val title = allFoodList!![i].title
                    if (title!!.contains(msg)) {
                        list.add(allFoodList!![i])
                    }
                    i++
                }
                mDatas!!.clear() // 清空ListView的适配器数据源内容
                mDatas!!.addAll(list) // 添加新的数据到数据源中
                adapter!!.notifyDataSetChanged() // 提示适配器更新
            }
        }
    }
}