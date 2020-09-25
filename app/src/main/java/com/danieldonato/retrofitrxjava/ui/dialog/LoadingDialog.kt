package com.danieldonato.retrofitrxjava.ui.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.ActionMode
import android.view.Window
import com.danieldonato.retrofitrxjava.R
import java.util.*

class LoadingDialog(context: Context): Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

}