package com.overman.main.presenter.view.main

import androidx.fragment.app.Fragment
import com.overman.main.R
import com.overman.main.databinding.FragmentSettingBinding
import com.overman.main.presenter.base.BindFragment

class SettingFragment: BindFragment<FragmentSettingBinding>(R.layout.fragment_setting) {

    companion object {
        fun newInstance(): Fragment {
            return SettingFragment()
        }
    }

    override fun initView() {

    }

    override fun initListener() {

    }

}