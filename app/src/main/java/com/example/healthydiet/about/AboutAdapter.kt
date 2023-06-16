package com.example.healthydiet.about

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class AboutAdapter(var viewList: List<View>) :
    PagerAdapter() {
    override fun getCount(): Int {
        return Int.MAX_VALUE
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = viewList[position % viewList.size]
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = viewList[position % viewList.size]
        container.removeView(view)
    }
}