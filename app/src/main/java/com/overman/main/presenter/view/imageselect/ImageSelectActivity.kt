package com.overman.main.presenter.view.imageselect

import android.content.Intent
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.overman.main.R
import com.overman.main.databinding.ActivityImageSelectBinding
import com.overman.main.presenter.base.DataBindViewModelActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.view.*

@AndroidEntryPoint
class ImageSelectActivity : DataBindViewModelActivity<ActivityImageSelectBinding, ImageSelectViewModel>(R.layout.activity_image_select)  {

    override val viewModel: ImageSelectViewModel by viewModels()

    override val actionBarType: Int = 0

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun initListener() {
    }

    override fun initObserve() {
        viewModel.imageDataList.observe(this) { imageDataList ->
        }
    }

    override fun initView() {
        setActionBar(binding.root.tbToolbar).also {
            it.setTitleText("타이틀")
        }
        binding.viewModel = viewModel

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }

        with (binding.rvImageDataListView) {
            layoutManager = GridLayoutManager(this@ImageSelectActivity,1)
            addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!binding.rvImageDataListView.canScrollVertically(1)) {
                        Toast.makeText(this@ImageSelectActivity, getString(R.string.main_next_data), Toast.LENGTH_SHORT).show()
                        viewModel.loadNextImageData(20)
                    }
                }
            })
        }

        viewModel.loadImageData(20)
    }
}