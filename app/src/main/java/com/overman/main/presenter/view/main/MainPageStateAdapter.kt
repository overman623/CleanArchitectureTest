package com.overman.main.presenter.view.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainPageStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    companion object {
        const val TYPE_HOME = 0
        const val TYPE_SHOP = 1
        const val TYPE_SETTING = 2
        const val TOTAL_COUNT = 3
    }

    private val fragmentList: ArrayList<Fragment> = ArrayList(TOTAL_COUNT)

    override fun getItemCount(): Int {
        return TOTAL_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            TYPE_HOME -> {
                val fragment = HomeFragment.newInstance()
                fragmentList.add(fragment)
                fragment
            }
            TYPE_SHOP -> {
                val fragment = ShopFragment.newInstance()
                fragmentList.add(fragment)
                fragment
            }
            TYPE_SETTING -> {
                val fragment = SettingFragment.newInstance()
                fragmentList.add(fragment)
                fragment
            }
            else -> {
                val fragment = HomeFragment.newInstance()
                fragmentList.add(fragment)
                fragment
            }
        }
    }

}