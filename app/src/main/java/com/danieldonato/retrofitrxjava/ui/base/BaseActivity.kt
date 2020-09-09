package com.danieldonato.retrofitrxjava.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore

abstract class BaseActivity<VM : ViewModel, B : ViewDataBinding> : AppCompatActivity() {

    private lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun getViewModel() : VM

    fun getBinding() : B {
        return binding
    }
}