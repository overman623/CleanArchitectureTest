package com.overman.main.presenter.extension

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowInsetsController

fun Activity.setStatusBarWhite() {
    if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.R) {
        val controller = window.insetsController
        window.statusBarColor = Color.WHITE
        controller?.setSystemBarsAppearance(
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)
    } else if (Build.VERSION.SDK_INT >= 23) {
        window.statusBarColor = Color.WHITE
        val view = window.decorView
        view.systemUiVisibility= view.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}