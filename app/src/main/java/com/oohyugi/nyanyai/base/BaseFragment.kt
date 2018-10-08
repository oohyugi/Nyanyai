package com.stickearn.stickpass.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity





/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
open class BaseFragment: Fragment(){


    override fun onDestroy() {

        super.onDestroy()
    }

    override fun onPause() {

        super.onPause()
    }

    lateinit var mContext: FragmentActivity
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Activity) {
            this.mContext = context as FragmentActivity
        }
    }


}