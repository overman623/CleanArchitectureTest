package com.overman.main.presenter.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import androidx.core.view.get
import androidx.databinding.ViewDataBinding
import androidx.databinding.adapters.ViewBindingAdapter
import com.overman.main.R
import com.overman.main.databinding.LayoutToolbarBinding
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class ActionBarCustomView (activity: AppCompatActivity, actionbarType: Int?): View.OnClickListener {

    private val binding = when (actionbarType) {
        0 -> {
            LayoutToolbarBinding.inflate(LayoutInflater.from(activity))
        }
        else -> {
            LayoutToolbarBinding.inflate(LayoutInflater.from(activity))
        }
    }

    private var block: ((View?) -> Unit)? = null

    init {
        if (actionbarType != null) {
            val actionBar = activity.supportActionBar
            actionBar?.setDisplayShowCustomEnabled(true)
            val layoutParams = ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            actionBar?.setCustomView(binding.root, layoutParams)
        }
    }

    fun setItemClickListener(block: (View?) -> Unit) {
        this.block = block
        binding.root.forEach { view ->
            if (view is ImageView) {
                view.setOnClickListener(this)
            }
        }
    }

    fun setTitleText(actionTitle : String?) {
        binding.root.tvTitleToolbar.text = actionTitle
    }

    override fun onClick(v: View?) {
        this.block?.invoke(v)
    }

}
