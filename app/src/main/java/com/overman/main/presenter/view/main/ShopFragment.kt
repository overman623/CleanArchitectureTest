package com.overman.main.presenter.view.main

import androidx.fragment.app.Fragment
import com.overman.main.R
import com.overman.main.databinding.FragmentShopBinding
import com.overman.main.presenter.base.BindFragment

class ShopFragment: BindFragment<FragmentShopBinding>(R.layout.fragment_shop) {

    companion object {
        fun newInstance(): Fragment {
            return ShopFragment()
        }
    }

    override fun initView() {

    }

    override fun initListener() {

    }

}