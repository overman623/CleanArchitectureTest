package com.overman.main.presenter.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import com.overman.main.presenter.common.ActionBarCustomView

abstract class DataBindActivity<B : ViewDataBinding>(@LayoutRes private val layoutId: Int) : BaseActivity() {

    lateinit var binding: B
    abstract val actionBarType: Int?
    private val actionBarCustomView: ActionBarCustomView by lazy {
        ActionBarCustomView(this, actionBarType)
    }

    abstract fun initView()

    abstract fun initListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)

        initView()
        initListener()
    }

    protected fun showSnackBar(text: String, time: Int = Snackbar.LENGTH_SHORT) {
        Snackbar.make(binding.root, text, time).show()
    }

    fun setActionBar(toolbar: Toolbar): ActionBarCustomView {
        setSupportActionBar(toolbar)
        return actionBarCustomView
    }

}