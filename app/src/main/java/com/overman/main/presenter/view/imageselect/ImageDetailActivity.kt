package com.overman.main.presenter.view.imageselect

import androidx.activity.viewModels
import com.overman.main.R
import com.overman.main.databinding.ActivityImageDetailBinding
import com.overman.main.presenter.base.DataBindViewModelActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailActivity : DataBindViewModelActivity<ActivityImageDetailBinding, ImageSelectViewModel>(R.layout.activity_image_detail) {

    override val viewModel: ImageSelectViewModel by viewModels()

    override val actionBarType: Int = 0

    override fun initListener() {
    }

    override fun initObserve() {
    }

    override fun initView() {
    }

}