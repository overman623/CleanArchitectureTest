package com.overman.main.presenter.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.overman.main.presenter.util.CLog

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CLog.d("onCreate:::$this")
    }

    override fun onStart() {
        super.onStart()
        CLog.d("onStart:::$this")
    }

    override fun onResume() {
        super.onResume()
        CLog.d("onResume:::$this")
    }

    override fun onPause() {
        super.onPause()
        CLog.d("onPause:::$this")
    }

    override fun onDestroy() {
        super.onDestroy()
        CLog.d("onDestroy:::$this")
    }

    override fun onRestart() {
        super.onRestart()
        CLog.d("onRestart:::$this")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        CLog.d("onNewIntent:::$this")
    }

    override fun finish() {
        super.finish()
        CLog.d("finish:::$this")
    }

}