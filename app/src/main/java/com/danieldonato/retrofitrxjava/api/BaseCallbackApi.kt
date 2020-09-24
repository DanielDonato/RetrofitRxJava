package com.danieldonato.retrofitrxjava.api

import com.danieldonato.retrofitrxjava.ui.base.BaseNavigator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseCallbackApi<T>(val baseNavigator: BaseNavigator) : Callback<T> {
//    private var context: Context

    init {
        baseNavigator.showLoadingDialog()
    }

    override fun onResponse(
        call: Call<T>,
        response: Response<T>
    ) {
        baseNavigator.dismissLoadingDialog()
//        alertStatusCode(response.code())
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        baseNavigator.dismissLoadingDialog()
//        whenConnectTimeOut(t)
    }

    private fun alertStatusCode(statusCode: Int) {
//        if (statusCode == 500) {
//            alert(
//                context,
//                "Falha",
//                "Um erro interno ocorreu no servidor, por favor tente mais tarde."
//            )
//        } else if (statusCode == 404) {
//            alert(
//                context,
//                "Falha",
//                "Servidor indisponível, por favor tente mais tarde."
//            )
//        } else if (statusCode == 401 || statusCode == 403) {
//            apiToken = null
//            val i = Intent(context, LoginActivity::class.java)
//            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//            context.startActivity(i)
//        }
    }

    private fun whenConnectTimeOut(throwable: Throwable) {
//        if (throwable is SocketTimeoutException
//            || throwable is ConnectTimeoutException
//        ) {
//            val intent = Intent(context, ServerErrorActivity::class.java)
//            intent.putExtra(
//                "message",
//                "Tempo para conexão esgostado ou servidor indisponível, por favor tente mais tarde."
//            )
//            context.startActivity(intent)
//        }
//        if (throwable is ConnectException) {
//            val intent = Intent(context, ServerErrorActivity::class.java)
//            intent.putExtra(
//                "message",
//                "Verifique seu acesso a internet ou tente novamente mais tarde."
//            )
//            context.startActivity(intent)
//        }
    }

}