package com.danieldonato.retrofitrxjava.ui.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.danieldonato.retrofitrxjava.viewmodel.BaseViewModel

public abstract class BaseFragment<VM : BaseViewModel<*>, B : ViewDataBinding> : Fragment() {

}