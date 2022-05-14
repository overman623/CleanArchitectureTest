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

    /**
     * setContentView로 호출할 Layout의 리소스 id.
     * ex) R.layout.activity_main
     */
    abstract val layoutId: Int

    /**
     * viewModel 로 쓰일 변수.
     */
    abstract val viewModel: VM

    /**
     * 뷰나 액티비티의 속성 등을 초기화.
     * ex) 리사이클러뷰, 툴바, 드로어뷰..
     */
    abstract fun initView()

    /**
     * 리스너 설정 (클릭, 스크롤, 페이저 등)
     */
    abstract fun initListener()

    /**
     * 데이터 바인딩 및 LiveData 설정.
     * ex) livedata observe, databinding observe..
     */
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