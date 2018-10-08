package com.oohyugi.nyanyai

import android.app.Application
import com.facebook.FacebookSdk

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
class NanyaiApp:Application() {

    override fun onCreate() {
        super.onCreate()
        FacebookSdk.sdkInitialize(applicationContext!!)
    }
}