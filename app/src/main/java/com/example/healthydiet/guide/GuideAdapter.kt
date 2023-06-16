package com.example.healthydiet.guide

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class GuideAdapter(var viewList: List<View>) :
    PagerAdapter() {
    override fun getCount(): Int {
        return viewList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = viewList[position]
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = viewList[position]
        container.removeView(view)
    }
}