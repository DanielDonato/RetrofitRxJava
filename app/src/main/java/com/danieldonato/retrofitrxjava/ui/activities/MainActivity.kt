package com.danieldonato.retrofitrxjava.ui.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.danieldonato.retrofitrxjava.R
import com.danieldonato.retrofitrxjava.databinding.ActivityMainBinding
import com.danieldonato.retrofitrxjava.ui.base.BaseActivity
import com.danieldonato.retrofitrxjava.ui.navigators.MainNavigator
import com.danieldonato.retrofitrxjava.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(), MainNavigator {

    private val mViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.navigator = this
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        return mViewModel
    }

    override fun getContext(): Context = this

}