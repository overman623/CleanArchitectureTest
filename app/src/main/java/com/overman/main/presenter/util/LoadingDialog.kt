package com.overman.main.presenter.util

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.overman.main.R

class LoadingDialog(context: Context) : AppCompatDialog(context, R.style.DialogStyle_Loading) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
        setCancelable(false)
    }
}