package com.danieldonato.retrofitrxjava.viewmodel

import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import com.danieldonato.retrofitrxjava.databinding.ActivityMainBinding
import com.danieldonato.retrofitrxjava.ui.base.BaseActivity
import com.danieldonato.retrofitrxjava.ui.navigators.MainNavigator

class MainViewModel : BaseViewModel<MainNavigator, ActivityMainBinding>() {

    init {
        binding.viewModel = this
    }

    fun onNextPageClick() {

    }
}