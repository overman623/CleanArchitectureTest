package com.overman.main.presenter.view.imageselect

import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.overman.main.R
import com.overman.main.databinding.ActivityImageDetailBinding
import com.overman.main.presenter.base.DataBindViewModelActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailActivity : DataBindViewModelActivity<ActivityImageDetailBinding, ImageSelectViewModel>(R.layout.activity_image_detail) {

    companion object {
        const val EXTRA_SELECT_IMAGE_ID = "EXTRA_SELECT_IMAGE_ID"
//        const val RESULT_CODE_FINISH_ACTIVITY = 1111
    }

    private val selectImageId: String by lazy {
        intent?.extras?.getString(EXTRA_SELECT_IMAGE_ID, "") ?: ""
    }

    override val viewModel: ImageSelectViewModel by viewModels()

    override val actionBarType: Int = 0

    override fun initListener() {
    }

    override fun initObserve() {
        binding.activity = this
        binding.viewModel = viewModel
//        setResult(RESULT_CODE_FINISH_ACTIVITY)
    }

    override fun initView() {
        Log.d(ImageSelectViewModel.TAG, "selectImageId : $selectImageId")
    }

    fun prevBtnClick(view: View) {
        Log.d(ImageSelectViewModel.TAG, "prevBtnClick")
    }

    fun nextBtnClick(view: View) {
        Log.d(ImageSelectViewModel.TAG, "nextBtnClick")
    }

    fun checkLike(view: View) {
        Log.d(ImageSelectViewModel.TAG, "checkLike")
    }

}