package com.danieldonato.retrofitrxjava.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.danieldonato.retrofitrxjava.R
import com.danieldonato.retrofitrxjava.databinding.ActivityMainBinding
import com.danieldonato.retrofitrxjava.ui.base.BaseActivity
import com.danieldonato.retrofitrxjava.ui.navigators.MainNavigator
import com.danieldonato.retrofitrxjava.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(MainViewModel::class.java), MainNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.navigator = this
        binding.viewModel = mViewModel
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun showCountries() {
        binding.rvCountries.layoutManager = LinearLayoutManager(this)
        binding.rvCountries.setHasFixedSize(true)
        binding.rvCountries.adapter = mViewModel.adapter
    }

}
