package com.overman.main.presenter.view.main

import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.overman.main.R
import com.overman.main.databinding.ActivityMainBinding
import com.overman.main.presenter.base.DataBindViewModelActivity
import com.overman.main.presenter.util.Lg
import com.overman.main.presenter.view.todo.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.view.*

@AndroidEntryPoint
class MainActivity : DataBindViewModelActivity<ActivityMainBinding, TodoViewModel>(R.layout.activity_main) {

    override val actionBarType: Int = 0
    override val viewModel: TodoViewModel by viewModels()
    lateinit var pagerAdapter: MainPageStateAdapter

    override fun initView() {
        setActionBar(binding.root.tbToolbar).also {
            it.setTitleText("타이틀")
        }
        binding.viewModel = viewModel
        initTab()
    }

    override fun initListener() {
    }

    override fun initObserve() {
        viewModel.todoRemoteData.observe(this) {
            Lg.d("TEST", it.toString())
        }
        viewModel.todoList()
    }

    private fun initTab() {
        pagerAdapter = MainPageStateAdapter(supportFragmentManager, lifecycle)

        binding.vpMain.offscreenPageLimit = 3
        binding.vpMain.adapter = pagerAdapter
        binding.vpMain.isUserInputEnabled = false

        TabLayoutMediator(binding.tlTabMain, binding.vpMain, false, false) { tab, position ->
            val tabItem = layoutInflater.inflate(R.layout.layout_main_tabitem, null)
            val ivTabIcon = tabItem.findViewById<ImageView>(R.id.ivTabIcon)
            val tvTabBottom = tabItem.findViewById<TextView>(R.id.tvTabBottom)

            when (position) {
                MainPageStateAdapter.TYPE_HOME -> {
                    ivTabIcon.setBackgroundResource(R.drawable.selector_tab_icon_home)
                    tvTabBottom.text = getString(R.string.home)
                    tab.customView = tabItem
                }
                MainPageStateAdapter.TYPE_SHOP -> {
                    ivTabIcon.setBackgroundResource(R.drawable.selector_tab_icon_shop)
                    tvTabBottom.text = getString(R.string.shop)
                    tab.customView = tabItem
                }
                MainPageStateAdapter.TYPE_SETTING -> {
                    ivTabIcon.setBackgroundResource(R.drawable.selector_tab_icon_setting)
                    tvTabBottom.text = getString(R.string.setting)
                    tab.customView = tabItem
                }
                else -> {
                    ivTabIcon.setBackgroundResource(R.drawable.selector_tab_icon_home)
                    tvTabBottom.text = getString(R.string.home)
                    tab.customView = tabItem
                }
            }
        }.attach()

        binding.vpMain.currentItem = 0
    }


    override fun handleViewEvent(event: Any) {
        super.handleViewEvent(event)
        when(event) {
            TodoViewModel.EVENT_SHOW_TODO_SUCCESS -> {

            }
            TodoViewModel.EVENT_SHOW_TODO_FAIL -> {

            }
        }
    }

}
