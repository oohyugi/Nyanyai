package com.stickearn.stickpass.base

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
interface BaseView {

    fun showLoading()
    fun errorLoading(errorMessage:String?)
    fun stopLoading()
}