package com.oohyugi.nyanyai.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeoutException


/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
abstract class BaseCallBack<T> : Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            onSuccess(response.body()!!)
        } else {
            onError(response.message())
        }

    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        if (t.message != null) {


            onError(t.message!!)

        }
    }

    protected abstract fun onError(errorMessage: String)

    protected abstract fun onSuccess(response: T)

}