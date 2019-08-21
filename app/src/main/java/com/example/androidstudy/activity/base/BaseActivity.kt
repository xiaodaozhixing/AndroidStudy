package com.example.androidstudy.activity.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.androidstudy.activity.base.presenter.BasePresenter

abstract class BaseActivity<T : BasePresenter<*>, B : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var mBinding: B
    protected lateinit var mPresenter: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = getPresenter()
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        useImmersiveStatusBar()
    }

    abstract fun getPresenter(): T

    abstract fun getLayoutId(): Int

    /**
     * 使用沉浸式状态栏
     */
    private fun useImmersiveStatusBar() {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        //延伸到状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        //设置状态栏为透明
        window.statusBarColor = Color.RED

        //为控件流出位置
        mBinding.root.fitsSystemWindows = true
        mBinding.root.clipToOutline = true
    }

    fun startActivity(from: Context){
        val intent = Intent(from, this.javaClass)
        if(from !is Activity){
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        from.startActivity(intent)
    }
}