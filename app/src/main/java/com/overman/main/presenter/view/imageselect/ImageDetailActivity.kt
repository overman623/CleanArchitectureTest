package com.overman.main.presenter.view.imageselect

import android.util.Log
import androidx.activity.viewModels
import com.overman.main.R
import com.overman.main.databinding.ActivityImageDetailBinding
import com.overman.main.presenter.base.DataBindViewModelActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailActivity : DataBindViewModelActivity<ActivityImageDetailBinding, ImageSelectViewModel>(R.layout.activity_image_detail) {

    companion object {
        const val EXTRA_SELECT_IMAGE_ID = "EXTRA_SELECT_IMAGE_ID"
    }

    private val selectImageId: String by lazy {
        intent?.extras?.getString(EXTRA_SELECT_IMAGE_ID, "") ?: ""
    }

    override val viewModel: ImageSelectViewModel by viewModels()

    override val actionBarType: Int = 0

    override fun initListener() {
    }

    override fun initObserve() {
    }

    override fun initView() {
        Log.d(ImageSelectViewModel.TAG, "2. 데이터 베이스에 데이터가 있는지 확인 : $selectImageId")
    }

}