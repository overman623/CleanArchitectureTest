package com.overman.main.presenter.view.main

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

        binding.vpMain.offscreenPageLimit = 4
        binding.vpMain.adapter = pagerAdapter
        binding.vpMain.isUserInputEnabled = false

        TabLayoutMediator(binding.tlTabMain, binding.vpMain, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
        }).attach()

        binding.vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })

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
