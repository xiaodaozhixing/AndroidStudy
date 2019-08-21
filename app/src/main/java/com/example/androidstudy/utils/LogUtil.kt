package com.example.androidstudy.utils

import android.util.Log
import androidx.annotation.IntDef
import java.lang.RuntimeException
import kotlin.math.min

object LogUtil {
    private const val ASSERT = 7
    private const val DEBUG = 3
    private const val ERROR = 6
    private const val INFO = 4
    private const val VERBOSE = 2
    private const val WARN = 5

    @IntDef(ASSERT, DEBUG, ERROR, INFO, VERBOSE, WARN)
    @Retention(AnnotationRetention.SOURCE)
    annotation class LogType

    private fun log(tag: String, msg: String, @LogType type: Int = INFO) {
        val realTag = "@CJL/$tag"
        when (type) {
            ASSERT -> Log.wtf(realTag, msg)
            DEBUG -> Log.d(realTag, msg)
            ERROR -> Log.e(realTag, msg)
            INFO -> Log.i(realTag, msg)
            VERBOSE -> Log.v(realTag, msg)
            WARN -> Log.w(realTag, msg)
            else -> throw RuntimeException("Can not find $type in LogType")
        }
    }

    fun logWtf(tag: String, msg: String) = log(tag, msg, ASSERT)
    fun logD(tag: String, msg: String) = log(tag, msg, DEBUG)
    fun logE(tag: String, msg: String) = log(tag, msg, ERROR)
    fun logI(tag: String, msg: String) = log(tag, msg, INFO)
    fun logV(tag: String, msg: String) = log(tag, msg, VERBOSE)
    fun logW(tag: String, msg: String) = log(tag, msg, WARN)

    fun logIterable(name: String, iterable: Iterable<*>, separator: String = ", ") {
        val sb = StringBuilder()
        iterable.forEach {
            sb.append(separator).append(it.toString())
        }
        logI(name, "[${sb.substring(min(separator.length, sb.length))}]")
    }
}