package com.overman.main.presenter.extension

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.overman.main.R
import com.overman.main.presenter.util.Lg
import java.text.DecimalFormat


@BindingAdapter(value = ["imgUrl", "scaleType"], requireAll = false)
fun ImageView.loadUrl(imgUrl: String?, scaleType: ImageView.ScaleType?) {
    Lg.d("IMAGE_TEST","+++=====+++=====+++=====+++=====+++=====+++=====+++=====")

    try {
        context?.let {
            if (!imgUrl.isNullOrEmpty()) {
                this.scaleType = scaleType ?: ImageView.ScaleType.CENTER_CROP

                Glide.with(it)
                    .load(imgUrl)
                    .apply(RequestOptions().centerCrop())
                    .into(this)
            } else {
                // default view
                Glide.with(it)
                    .load(R.drawable.img_back)
                    .apply(RequestOptions().centerCrop())
                    .into(this)
            }
        }
    } catch (e: Exception) {
        Lg.e(e.toString())
    }
}

@BindingAdapter(value = ["profileImg"])
fun ImageView.profileImg(url: String?) {
    try {
        context?.let {
            if (!url.isNullOrEmpty()) {
                Glide.with(it)
                    .load(url)
                    .apply(RequestOptions().circleCrop())
                    .into(this)
            } else {
                // default view
                Glide.with(it)
                    .load(R.drawable.img_back)
                    .apply(RequestOptions().circleCrop())
                    .into(this)
            }
        }
    } catch (e: Exception) {
        Lg.e(e.toString())
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter(value = ["steps"])
fun TextView.steps(steps: Int?) {
    text = if (steps != null) {
        try {
            "${DecimalFormat("#,##0").format(steps)} 걸음"
        } catch (e: Exception) {
            "0 걸음"
        }
    } else {
        "0 걸음"
    }
}