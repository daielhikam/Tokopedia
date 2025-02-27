package com.example.mytokopedia.tabLayoutHome

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentHome: Fragment) : FragmentStateAdapter(fragmentHome) {
    private val fragmentList = listOf(FormeFragment(), MallFragmentTab(), ElektronikFragment(), FragmentDekat(), FragmentMirip())
    private val fragmentTitleList = listOf("For Dai", "Mall", "Elektronik", "Dekat Kamu", "Mirip Yang Kamu Cek")

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun getPageTitle(position: Int): String {
        return fragmentTitleList[position]
    }
}