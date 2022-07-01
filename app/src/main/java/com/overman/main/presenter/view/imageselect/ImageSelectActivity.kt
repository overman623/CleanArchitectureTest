package com.overman.main.presenter.view.imageselect

import androidx.activity.viewModels
import com.overman.main.R
import com.overman.main.databinding.ActivityImageSelectBinding
import com.overman.main.presenter.base.DataBindViewModelActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageSelectActivity : DataBindViewModelActivity<ActivityImageSelectBinding, ImageSelectViewModel>(R.layout.activity_image_select)  {

    override val viewModel: ImageSelectViewModel by viewModels()

    override val actionBarType: Int = 0

    override fun initView() {
    }

    override fun initListener() {
    }

    override fun initObserve() {
    }
}