package com.overman.main.presenter.common

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.view.forEach
import com.overman.main.R
import com.overman.main.databinding.LayoutToolbarBinding
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class ActionBarCustomView (activity: AppCompatActivity, actionbarType: Int?): View.OnClickListener {

    private val backgroundColor = when (actionbarType) {
        0 -> {
            ActivityCompat.getColor(activity, R.color.c_ff3258)
        }
        else -> {
            ActivityCompat.getColor(activity, R.color.c_ff3258)
        }
    }

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
            val layoutParams = ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT)

            val customView: View = binding.root
            actionBar?.setCustomView(customView, layoutParams)
            val parent = customView.parent as Toolbar
            parent.setBackgroundColor(backgroundColor)
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
