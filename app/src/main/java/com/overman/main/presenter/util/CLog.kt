package com.overman.main.presenter.util

import android.util.Log
import com.overman.main.MyApplication

internal object CLog {

    private const val mTag = "TODO_APP"

    private fun logMsg(msg: String?): String {
        val stack = Throwable().stackTrace
        val currentStack = stack[2]
        return currentStack.className + "\t[Line:" + currentStack.lineNumber + "]\t" + currentStack.methodName + " -> " + msg
    }

    fun v(msg: String?) {
        if (MyApplication.TEST) {
            Log.v(mTag, logMsg(msg))
        }
    }

    fun v(tag: String, msg: String?) {
        if (MyApplication.TEST) {
            Log.v(tag, logMsg(msg))
        }
    }

    fun d(msg: String?) {
        if (MyApplication.TEST) {
            Log.d(mTag, logMsg(msg))
        }
    }

    fun d(tag: String, msg: String?) {
        if (MyApplication.TEST) {
            Log.d(tag, logMsg(msg))
        }
    }

    fun e(msg: String?) {
        if (MyApplication.TEST) {
            Log.e(mTag, logMsg(msg))
        }
    }

    fun e(tag: String, msg: String?) {
        if (MyApplication.TEST) {
            Log.e(tag, logMsg(msg))
        }
    }

    fun e(msg: String?, throwable: Throwable?) {
        if (MyApplication.TEST) {
            Log.e(mTag, logMsg(msg), throwable)
        }
    }

    fun e(tag: String, msg: String?, throwable: Throwable?) {
        if (MyApplication.TEST) {
            Log.e(tag, logMsg(msg), throwable)
        }
    }
}