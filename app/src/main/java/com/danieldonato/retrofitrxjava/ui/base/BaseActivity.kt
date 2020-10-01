package com.danieldonato.retrofitrxjava.ui.base

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.get
import com.danieldonato.retrofitrxjava.ui.dialog.LoadingDialog
import com.danieldonato.retrofitrxjava.viewmodel.BaseViewModel
import java.lang.ref.WeakReference

abstract class BaseActivity<VM: BaseViewModel<B>, B : ViewDataBinding>
    (private var classViewModel: Class<VM>): AppCompatActivity() {

    val mViewModel by lazy {
        ViewModelProvider(this).get(classViewModel)
    }

    lateinit var binding: B

    lateinit var loadingDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        binding.lifecycleOwner = this
        mViewModel.binding = binding

        mViewModel.liveDataLoading
            .observe(this, Observer {
                if(it) {
                    startLoading()
                }else {
                    stopLoading()
                }
            })

        mViewModel.liveDataOpenActivity
            .observe(this, Observer {
                openActivity(it)
            })

    }

    fun startLoading() {
        loadingDialog = LoadingDialog(this)
        loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loadingDialog.show()
    }

    fun stopLoading() {
        if(this::loadingDialog.isInitialized && loadingDialog.isShowing) {
            loadingDialog.dismiss()
        }
    }

    fun openActivity(activity: Class<*>) {
        val i = Intent(this, activity)
        startActivity(i)
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int
}