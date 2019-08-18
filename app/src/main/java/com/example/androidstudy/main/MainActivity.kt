package com.example.androidstudy.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidstudy.R
import com.example.androidstudy.base.BaseActivity
import com.example.androidstudy.databinding.ActivityMainBinding
import com.example.androidstudy.main.contract.MainContractView
import com.example.androidstudy.main.presenter.MainPresenter

class MainActivity : BaseActivity<MainPresenter, ActivityMainBinding>(), MainContractView {
    override fun getPresenter(): MainPresenter = MainPresenter(this)
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
