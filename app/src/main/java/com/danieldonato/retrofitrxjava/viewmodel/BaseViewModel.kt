package com.danieldonato.retrofitrxjava.viewmodel

import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<B : ViewDataBinding>: ViewModel() {

    lateinit var binding: B
    val liveDataLoading = MutableLiveData<Boolean>()
    val liveDataOpenActivity = MutableLiveData<Class<*>>()

}