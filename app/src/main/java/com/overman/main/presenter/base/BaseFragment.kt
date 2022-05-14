package com.overman.main.presenter.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.overman.main.presenter.util.CLog

abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CLog.d("onViewCreated:::$this")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CLog.d("onCreate:::$this")
    }

    override fun onResume() {
        super.onResume()
        CLog.d("onResume:::$this")
    }

    override fun onPause() {
        super.onPause()
        CLog.d("onPause:::$this")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        CLog.d("onDestroyView:::$this")
    }

    override fun onDestroy() {
        super.onDestroy()
        CLog.d("onDestroy:::$this")
    }

}