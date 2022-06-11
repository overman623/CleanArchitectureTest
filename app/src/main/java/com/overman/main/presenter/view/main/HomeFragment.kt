package com.overman.main.presenter.view.main

import androidx.fragment.app.Fragment
import com.overman.main.R
import com.overman.main.databinding.FragmentHomeBinding
import com.overman.main.presenter.base.BindFragment

class HomeFragment: BindFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    companion object {
        fun newInstance(): Fragment {
            return HomeFragment()
        }
    }

    override fun initView() {

    }

    override fun initListener() {

    }

}