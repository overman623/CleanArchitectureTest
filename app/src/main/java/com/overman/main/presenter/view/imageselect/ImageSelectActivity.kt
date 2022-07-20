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
class ImageSelectActivity : DataBindViewModelActivity<ActivityImageSelectBinding, ImageSelectViewModel>(R.layout.activity_image_select) {
    //https://appmattus.medium.com/caching-made-simple-on-android-d6e024e3726b
    override val viewModel: ImageSelectViewModel by viewModels()
    override val actionBarType: Int = 0
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    private val imageAdapter = ImageAdapter(actionCheckLike = { id, like ->
        //좋아요 기능 갱신
        true
    })

    override fun initListener() {
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }
    }

    override fun initObserve() {
        viewModel.imageResponseDataList.observe(this) { imageList ->
            imageAdapter.addImageList(imageList)
        }
    }

    override fun initView() {
        setActionBar(binding.root.tbToolbar).also {
            it.setTitleText("타이틀")
        }
        binding.viewModel = viewModel

        with (binding.rvImageDataListView) {
            adapter = imageAdapter
            layoutManager = GridLayoutManager(this@ImageSelectActivity,1)
            addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!binding.rvImageDataListView.canScrollVertically(1)) {
                        Toast.makeText(this@ImageSelectActivity, getString(R.string.main_next_data), Toast.LENGTH_SHORT).show()
                        viewModel.loadNextImageData(10)
                    }
                }
            })
        }

        viewModel.loadImageData(10)
    }

    fun executeDetailActivity(id: String?) {
        if (id != null) {
            activityResultLauncher.launch(Intent(this@ImageSelectActivity, ImageDetailActivity::class.java).apply {
                putExtra(ImageDetailActivity.EXTRA_SELECT_IMAGE_ID, id)
            })
        }
    }
}