package com.example.androidstudy.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.androidstudy.base.presenter.BasePresenter

abstract class BaseActivity<T:BasePresenter<*>, B: ViewDataBinding>: AppCompatActivity() {
    protected lateinit var mBinding: B
    protected lateinit var mPresenter: T
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        mPresenter = getPresenter()
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    abstract fun getPresenter():T

    abstract fun getLayoutId():Int
}