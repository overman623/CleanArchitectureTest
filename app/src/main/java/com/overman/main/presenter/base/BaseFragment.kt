package com.overman.main.presenter.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.overman.main.presenter.util.Lg

abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Lg.d("onViewCreated:::$this")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Lg.d("onCreate:::$this")
    }

    override fun onResume() {
        super.onResume()
        Lg.d("onResume:::$this")
    }

    override fun onPause() {
        super.onPause()
        Lg.d("onPause:::$this")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Lg.d("onDestroyView:::$this")
    }

    override fun onDestroy() {
        super.onDestroy()
        Lg.d("onDestroy:::$this")
    }

}