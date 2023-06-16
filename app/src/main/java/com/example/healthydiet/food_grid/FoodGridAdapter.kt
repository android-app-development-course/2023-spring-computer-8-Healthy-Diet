package com.example.healthydiet.food_grid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.healthydiet.R
import com.example.healthydiet.bean.FoodBean

class FoodGridAdapter(var context: Context, var mDatas: List<FoodBean>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return mDatas.size
    }

    override fun getItem(position: Int): Any {
        return mDatas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
//        1.声明ViewHolder
        var convertView = convertView
        var holder: ViewHolder? = null
        if (convertView == null) { //2.判断是否有复用的view，如果没有就创建
            convertView = LayoutInflater.from(context).inflate(R.layout.item_foodgrid, null)
            holder = ViewHolder(convertView)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        //        获取指定位置的数据
        val foodBean = mDatas[position]
        holder!!.iv.setImageResource(foodBean.picId)
        holder.tv.text = foodBean.title
        return convertView
    }

    internal inner class ViewHolder(view: View) {
        var iv: ImageView
        var tv: TextView

        init {
            iv = view.findViewById<ImageView>(R.id.item_grid_iv)
            tv = view.findViewById<TextView>(R.id.item_grid_tv)
        }
    }
}