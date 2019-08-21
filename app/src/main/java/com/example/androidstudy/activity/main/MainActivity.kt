package com.example.androidstudy.activity.main

import android.os.Bundle
import com.example.androidstudy.R
import com.example.androidstudy.activity.base.BaseActivity
import com.example.androidstudy.databinding.ActivityMainBinding
import com.example.androidstudy.activity.main.contract.MainContractView
import com.example.androidstudy.activity.main.presenter.MainPresenter
import com.example.androidstudy.utils.LogUtil
import com.example.androidstudy.utils.PathUtil

class MainActivity : BaseActivity<MainPresenter, ActivityMainBinding>(), MainContractView {
    override fun getPresenter(): MainPresenter = MainPresenter(this)
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PathUtil.createTxtFile(applicationContext, "txt", "Hello.txt", "Hello txt")
    }

}
