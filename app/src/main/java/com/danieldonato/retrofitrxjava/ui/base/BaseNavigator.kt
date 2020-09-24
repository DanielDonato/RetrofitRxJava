package com.danieldonato.retrofitrxjava.ui.base

import android.os.Bundle

interface BaseNavigator {

    fun <T> openActivity(activity: Class<T>, finishActivity: Boolean, bundle: Bundle)
    fun showLoadingDialog()
    fun dismissLoadingDialog()
    fun showToast(text: String)

}