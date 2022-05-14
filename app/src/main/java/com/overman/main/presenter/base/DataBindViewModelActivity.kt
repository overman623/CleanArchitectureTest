package com.overman.main.presenter.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.overman.main.presenter.util.LoadingDialog
import com.overman.main.presenter.util.livedata.EventObserver

abstract class DataBindViewModelActivity<B : ViewDataBinding, VM : BaseViewModel>(@LayoutRes private val layoutId: Int) : DataBindActivity<B>(layoutId) {

    /**
     * viewModel 로 쓰일 변수.
     */
    abstract val viewModel: VM

    private val loadingDialog: LoadingDialog? by lazy {
        LoadingDialog(this)
    }

    /**
     * 데이터 바인딩 및 LiveData 설정.
     * ex) livedata observe, databinding observe..
     */
    abstract fun initObserve()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObserve()
        observeViewEvent()
    }

    override fun onDestroy() {
        super.onDestroy()
        hideLoadingView()
    }

    private fun showLoadingView() {
        loadingDialog?.run {
            if (!isShowing) {
                show()
            }
        }
    }

    private fun hideLoadingView() {
        loadingDialog?.run {
            if (!isDestroyed && isShowing) {
                dismiss()
            }
        }
    }

    private fun observeViewEvent() {
        viewModel.viewEvent.observe(this, EventObserver(this::handleViewEvent))
    }

    open fun handleViewEvent(event: Any) {
        when (event) {
            BaseViewModel.EVENT_SHOW_LOADING_VIEW -> {
                showLoadingView()
            }

            BaseViewModel.EVENT_HIDE_LOADING_VIEW,
            BaseViewModel.EVENT_SOCKET_EXCEPTION,
            BaseViewModel.EVENT_HTTP_EXCEPTION,
            BaseViewModel.EVENT_UNKNOWN_HOST_EXCEPTION,
            BaseViewModel.EVENT_COROUTINE_EXCEPTION -> {
                hideLoadingView()
            }
        }
    }
}