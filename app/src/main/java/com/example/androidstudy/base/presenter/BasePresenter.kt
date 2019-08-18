package com.example.androidstudy.base.presenter

import com.example.androidstudy.base.contract.BaseContractView

open class BasePresenter<T: BaseContractView> (protected val mContract: T)