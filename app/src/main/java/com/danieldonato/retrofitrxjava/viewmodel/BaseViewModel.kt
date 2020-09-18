package com.danieldonato.retrofitrxjava.viewmodel

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.danieldonato.retrofitrxjava.ui.base.BaseNavigator

abstract class BaseViewModel<N : BaseNavigator, B : ViewDataBinding>: ViewModel() {

    var navigator: N
        get() = navigator
        set(value) {
            navigator = value
        }

    var binding: B
        get() = binding
        set(value) {
            binding = value
        }

}