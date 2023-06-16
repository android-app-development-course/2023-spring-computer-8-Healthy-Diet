package com.example.healthydiet.food_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.healthydiet.R
import com.example.healthydiet.bean.FoodBean

class InfoListAdapter(var context: Context, var mDatas: List<FoodBean>) :
    BaseAdapter() {
    //  决定了ListView列表展示的行数
    override fun getCount(): Int {
        return mDatas.size
    }

    //返回指定位置对应的数据
    override fun getItem(position: Int): Any {
        return mDatas[position]
    }

    // 返回指定位置所对应的id
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        var holder: ViewHolder? = null
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_infolist_lv, null) //将布局转换成view对象的方法
            holder = ViewHolder(convertView)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        //        加载控件显示的内容
//        获取集合指定位置的数据
        val foodBean = mDatas[position]
        holder!!.titleTv.text = foodBean.title
        holder.notTv.text = "不可匹配:" + foodBean.notmatch
        holder.iv.setImageResource(foodBean.picId)
        return convertView
    }

    internal inner class ViewHolder(view: View) {
        var iv: ImageView
        var titleTv: TextView
        var notTv: TextView

        init {
            iv = view.findViewById<ImageView>(R.id.item_info_iv)
            titleTv = view.findViewById<TextView>(R.id.item_info_tv_title)
            notTv = view.findViewById<TextView>(R.id.item_info_tv_notmatch)
        }
    }
}