package com.oohyugi.nyanyai.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.oohyugi.nyanyai.MainActivity
import com.oohyugi.nyanyai.R
import com.oohyugi.nyanyai.helper.PrefHelper
import com.oohyugi.nyanyai.view.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        Handler().postDelayed({

            if (PrefHelper.getLoggedUser(this)!=null){
                MainActivity.startThisActivity(this)
                finish()
            }else{
                LoginActivity.startThisActivity(this)
                finish()
            }

        },5000)
    }
}
