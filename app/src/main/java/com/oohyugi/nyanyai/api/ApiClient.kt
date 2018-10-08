package com.oohyugi.nyanyai.api

import okhttp3.Interceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
class ApiClient(baseURL: String) {

    lateinit var mApiServices: ApiService


    init {
        val retrofit = initRetrofit(baseURL)
        initServices(retrofit)
    }

    private fun initServices(retrofit: Retrofit) {
        mApiServices = retrofit.create(ApiService::class.java)
    }

    fun getApiServices(): ApiService {
        return mApiServices
    }

    private fun initRetrofit(baseURL: String): Retrofit {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {
            networkInterceptors().add(Interceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                        .method(original.method(), original.body())
                        .build()
                chain.proceed(request)
            })
            readTimeout(10, TimeUnit.SECONDS)
            connectTimeout(10, TimeUnit.SECONDS)
            writeTimeout(10, TimeUnit.SECONDS)
            addInterceptor(interceptor)
        }
        return Retrofit.Builder().baseUrl(baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
    }
}

