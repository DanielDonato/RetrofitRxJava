package com.danieldonato.retrofitrxjava.viewmodel

import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.danieldonato.retrofitrxjava.ui.base.BaseNavigator

abstract class BaseViewModel<N : BaseNavigator, B : ViewDataBinding>: ViewModel() {

    lateinit var navigator: N

//
//    var navigator: N? = null
//        set(value) {
//            field = value
//            Log.d("__res", "Setando")
//        }

    lateinit var binding: B

}