package com.overman.main.presenter.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.overman.main.presenter.util.Lg

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Lg.d("onCreate:::$this")
    }

    override fun onStart() {
        super.onStart()
        Lg.d("onStart:::$this")
    }

    override fun onResume() {
        super.onResume()
        Lg.d("onResume:::$this")
    }

    override fun onPause() {
        super.onPause()
        Lg.d("onPause:::$this")
    }

    override fun onDestroy() {
        super.onDestroy()
        Lg.d("onDestroy:::$this")
    }

    override fun onRestart() {
        super.onRestart()
        Lg.d("onRestart:::$this")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Lg.d("onNewIntent:::$this")
    }

    override fun finish() {
        super.finish()
        Lg.d("finish:::$this")
    }

}