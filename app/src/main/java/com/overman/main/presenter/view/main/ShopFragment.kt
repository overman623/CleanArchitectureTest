package com.overman.main.presenter.view.main

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.overman.main.R
import com.overman.main.databinding.FragmentShopBinding
import com.overman.main.presenter.base.BindFragment
import com.overman.main.presenter.common.GridSpacingItemDecoration
import com.overman.main.presenter.view.main.setting.SettingItemAdapter
import com.overman.main.presenter.view.main.setting.SettingListData
import com.overman.main.presenter.view.main.shop.ShopItemAdapter
import com.overman.main.presenter.view.main.shop.ShopListData

class ShopFragment: BindFragment<FragmentShopBinding>(R.layout.fragment_shop) {

    companion object {
        fun newInstance(): Fragment {
            return ShopFragment()
        }
    }

    private val itemList = ArrayList<ShopListData>().also {
        it.add(ShopListData("Item1"))
        it.add(ShopListData("Item2"))
        it.add(ShopListData("Item3"))
        it.add(ShopListData("Item4"))
    }

    private val shopAdapter = ShopItemAdapter(itemList)

    override fun initView() {
        binding.rvShop.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvShop.addItemDecoration(GridSpacingItemDecoration(spanCount = 1, spacing = 0, includeEdge = false))
        binding.rvShop.adapter = shopAdapter
    }

    override fun initListener() {

    }

}