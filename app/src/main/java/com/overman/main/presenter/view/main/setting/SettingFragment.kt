package com.overman.main.presenter.view.main.setting

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.overman.main.R
import com.overman.main.databinding.FragmentSettingBinding
import com.overman.main.presenter.base.BindFragment
import com.overman.main.presenter.common.GridSpacingItemDecoration

class SettingFragment: BindFragment<FragmentSettingBinding>(R.layout.fragment_setting) {

    companion object {
        fun newInstance(): Fragment {
            return SettingFragment()
        }
    }

    private val itemList = ArrayList<SettingListData>().also {
        it.add(SettingListData("Item1"))
        it.add(SettingListData("Item2"))
        it.add(SettingListData("Item3"))
        it.add(SettingListData("Item4"))
    }

    private val homeAdapter = SettingItemAdapter(itemList)

    override fun initView() {
        binding.rvSetting.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvSetting.addItemDecoration(GridSpacingItemDecoration(spanCount = 1, spacing = 0, includeEdge = false))
        binding.rvSetting.adapter = homeAdapter
    }

    override fun initListener() {

    }

}