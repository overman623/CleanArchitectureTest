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
        it.add(HomeListData("Item1"))
        it.add(HomeListData("Item2"))
        it.add(HomeListData("Item3"))
        it.add(HomeListData("Item4"))
    }

    private val homeAdapter = HomeItemAdapter(itemList)

    override fun initView() {
        binding.rvHomeItem.layoutManager = GridLayoutManager(requireContext(), 2)
//        val spanCount = 2
//        val spacing = 25
//        val includeEdge = true
//        binding.rvHomeItem.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing, includeEdge))
        binding.rvHomeItem.adapter = homeAdapter
    }

    override fun initListener() {

    }

}