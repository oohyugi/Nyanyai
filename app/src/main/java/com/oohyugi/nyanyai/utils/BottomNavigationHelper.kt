package com.oohyugi.nyanyai.utils

import android.annotation.SuppressLint
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.util.Log

import java.lang.reflect.Field

/**
 * Created by yogi on 05/03/17.
 */
class BottomNavigationHelper {
    lateinit var menuView: BottomNavigationMenuView
    @SuppressLint("RestrictedApi")
    fun disableShiftMode(view: BottomNavigationView) {
        try {

            menuView = view.getChildAt(0) as BottomNavigationMenuView

        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false
            for (i in 0 until menuView.childCount) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView

                item.setShiftingMode(false)
                // set once again checked value, so view will be updated

                item.setChecked(item.itemData.isChecked)
            }
        } catch (e: NoSuchFieldException) {
            Log.e("BNVHelper", "Unable to get shift mode field", e)
        } catch (e: IllegalAccessException) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e)
        }

    }
}