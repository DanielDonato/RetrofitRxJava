package com.danieldonato.retrofitrxjava.ui.base

import android.os.Bundle

interface BaseNavigation {

    fun <T> openActivity(activity: Class<T>, finishActivity: Boolean, bundle: Bundle)

}