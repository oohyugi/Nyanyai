package com.oohyugi.nyanyai.helper

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
object FragmentHelper {
    fun replaceFragment(activity: FragmentActivity?, fragment: Fragment?, idContainer: Int) {
        if (activity != null) {
            activity.supportFragmentManager.beginTransaction()
                    .replace(idContainer, fragment)
                    .commit()
        }
    }

    fun addFragment(activity: AppCompatActivity, fragment: Fragment, idContainer: Int) {
        activity.supportFragmentManager.beginTransaction()
                .add(idContainer, fragment)
                .commit()
    }

}