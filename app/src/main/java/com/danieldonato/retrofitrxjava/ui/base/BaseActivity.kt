package com.danieldonato.retrofitrxjava.ui.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.danieldonato.retrofitrxjava.viewmodel.BaseViewModel

abstract class BaseActivity<VM : BaseViewModel<*, *>, B : ViewDataBinding> : AppCompatActivity(), BaseNavigator {

    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun getViewModel() : VM

    override fun <T> openActivity(activity: Class<T>, finishActivity: Boolean, bundle: Bundle) {

    }

    override fun showLoadingDialog() {

    }

    override fun dismissLoadingDialog() {

    }
}