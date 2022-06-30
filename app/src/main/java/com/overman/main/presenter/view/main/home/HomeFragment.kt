package com.overman.main.presenter.view.main.home

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.overman.main.R
import com.overman.main.databinding.FragmentHomeBinding
import com.overman.main.presenter.base.BindFragment
import com.overman.main.presenter.common.GridSpacingItemDecoration

class HomeFragment: BindFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    companion object {
        fun newInstance(): Fragment {
            return HomeFragment()
        }
    }

    private val itemList = ArrayList<HomeListData>().also {
        it.add(HomeListData(0, "이미지 선택"))
        it.add(HomeListData(1, "Item2"))
        it.add(HomeListData(2, "Item3"))
        it.add(HomeListData(3, "Item4"))
    }

    private val homeAdapter = HomeItemAdapter(itemList)

    override fun initView() {
        binding.rvHome.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvHome.addItemDecoration(GridSpacingItemDecoration(spanCount = 2, spacing = 25, includeEdge = true))
        binding.rvHome.adapter = homeAdapter
    }

    override fun initListener() {

    }

}