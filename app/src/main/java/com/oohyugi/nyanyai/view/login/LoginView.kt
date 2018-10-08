package com.oohyugi.nyanyai.view.login

import com.oohyugi.nyanyai.model.UserMdl
import com.stickearn.stickpass.base.BaseView

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
interface LoginView: BaseView {
    fun onSuccessLogin(mUser: UserMdl)
}