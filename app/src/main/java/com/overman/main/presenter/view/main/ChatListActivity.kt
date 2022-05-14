package com.overman.main.presenter.view.main

import androidx.activity.viewModels
import com.overman.main.R
import com.overman.main.databinding.ActivityChatListBinding
import com.overman.main.databinding.ActivityMainBinding
import com.overman.main.presenter.base.DataBindViewModelActivity
import com.overman.main.presenter.common.ActionBarCustomView
import com.overman.main.presenter.util.CLog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.view.*

@AndroidEntryPoint
class ChatListActivity : DataBindViewModelActivity<ActivityChatListBinding, TodoViewModel>(R.layout.activity_chat_list) {

    override val actionBarType: Int = 0
    override val viewModel: TodoViewModel by viewModels()

    override fun initView() {
        setActionBar(binding.root.tbToolbar).also {
            it.setTitleText("타이틀")
        }
        binding.viewModel = viewModel
    }

    override fun initListener() {
    }

    override fun initObserve() {
        viewModel.todoRemoteData.observe(this) {
            CLog.d(it.toString())
        }
        viewModel.todoList()
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

