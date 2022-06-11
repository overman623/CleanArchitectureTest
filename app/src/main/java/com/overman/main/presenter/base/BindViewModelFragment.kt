package com.overman.main.presenter.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.overman.main.presenter.util.livedata.EventObserver

abstract class BindViewModelFragment<B : ViewDataBinding, VM : BaseViewModel> : BaseFragment() {

    private var _binding: B? = null
    open val binding: B get() = _binding!!

    abstract val layoutId: Int

    abstract val viewModel: VM

    abstract fun initView()

    abstract fun initListener()

    abstract fun initObserve()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListener()
        initObserve()
        observeViewEvent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeViewEvent() {
        viewModel.viewEvent.observe(viewLifecycleOwner, EventObserver(this::handleViewEvent))
    }

    open fun handleViewEvent(event: Any) {

    }
}