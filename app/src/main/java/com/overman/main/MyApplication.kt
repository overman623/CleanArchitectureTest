package com.overman.main

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : MultiDexApplication()  {
    companion object {
        const val TEST = true
    }
}