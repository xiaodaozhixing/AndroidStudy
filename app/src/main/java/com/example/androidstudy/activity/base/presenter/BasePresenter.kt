package com.example.androidstudy.activity.base.presenter

import com.example.androidstudy.activity.base.contract.BaseContractView

open class BasePresenter<T: BaseContractView> (protected val mContract: T)