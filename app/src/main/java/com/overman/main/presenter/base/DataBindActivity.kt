package com.overman.main.presenter.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import com.overman.main.presenter.common.ActionBarCustomView
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.Exception

abstract class DataBindActivity<B : ViewDataBinding>(@LayoutRes private val layoutId: Int) : BaseActivity() {

    lateinit var binding: B
    abstract val actionBarType: Int?
    private val actionBarCustomView: ActionBarCustomView by lazy {
        ActionBarCustomView(this, actionBarType)
    }

    /**
     * 뷰나 액티비티의 속성 등을 초기화.
     * ex) 리사이클러뷰, 툴바, 드로어뷰..
     */
    abstract fun initView()

    /**
     * 리스너 설정 (클릭, 스크롤, 페이저 등)
     */
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