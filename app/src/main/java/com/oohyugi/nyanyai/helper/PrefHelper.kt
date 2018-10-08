package com.oohyugi.nyanyai.helper

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.oohyugi.nyanyai.model.UserMdl

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
object PrefHelper {


    private val PREF_USER = "PREF_USER"

    private val mPreferences: SharedPreferences? = null

    private fun getSP(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
    fun savePref(context: Context, key: String, value: String) {
        getSP(context).edit().putString(key, value).commit()
    }

    fun getPref(context: Context, key: String): String? {
        return getSP(context).getString(key, null)
    }
    fun saveLoggedUser(mContex: Context, mdao: UserMdl?) {
            val pref = PreferenceManager
                    .getDefaultSharedPreferences(mContex)
            pref.edit().putString(PREF_USER, Gson().toJson(mdao)).apply()

        }

        fun getLoggedUser(mContext: Context): UserMdl? {
            return Gson().fromJson<UserMdl>(getPref(mContext, PREF_USER), UserMdl::class.java)


        }
    }
