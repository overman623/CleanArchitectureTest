package com.overman.main.presenter.view.main.jetpack

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.overman.main.R
import com.overman.main.databinding.FragmentJetpackBinding
import com.overman.main.presenter.base.BindFragment
import com.overman.main.presenter.common.GridSpacingItemDecoration

class JetpackFragment: BindFragment<FragmentJetpackBinding>(R.layout.fragment_jetpack) {

    companion object {

        const val INDEX_WORKER_MANAGER = 0

        fun newInstance(): Fragment {
            return JetpackFragment()
        }
    }

    private val itemList = ArrayList<JetpackListData>().also {
        it.add(JetpackListData(INDEX_WORKER_MANAGER, "WorkerManager"))
        it.add(JetpackListData(1, "Item2"))
        it.add(JetpackListData(2, "Item3"))
        it.add(JetpackListData(3, "Item4"))
    }

    private val jetpackAdapter = JetpackItemAdapter(itemList)

    override fun initView() {
        binding.rvJetpack.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvJetpack.addItemDecoration(GridSpacingItemDecoration(spanCount = 1, spacing = 0, includeEdge = false))
        binding.rvJetpack.adapter = jetpackAdapter
    }

    override fun initListener() {

    }

}