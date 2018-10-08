package com.oohyugi.nyanyai.view.login

import android.os.Bundle
import android.util.Log
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.oohyugi.nyanyai.model.UserMdl
import com.stickearn.stickpass.base.BasePresenter
import org.json.JSONObject

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
class LoginPresenter(mView: LoginView) : BasePresenter<LoginView>(mView) {

    fun loginWithFB(mContext: LoginActivity, callbackManager: CallbackManager?, permissionNeeds: List<String>) {
        mView.showLoading()
        LoginManager.getInstance().logInWithReadPermissions(mContext, permissionNeeds)
        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {

                facebookUser(loginResult.accessToken)

            }

            override fun onCancel() {
                Log.e("cancel", "onCancel: ")
                val token = AccessToken.getCurrentAccessToken()
                if (token != null) {
                    facebookUser(token)
                } else {

                }
//                    Log.e("cancel", "onCancel: " + token!!.userId)

            }

            override fun onError(error: FacebookException) {
                mView.stopLoading()
                mView.errorLoading(error.message)
                Log.e("cancel", "onError: " + error.message)

            }
        })
    }

    private fun facebookUser(token: AccessToken?) {
        val request: GraphRequest = GraphRequest.newMeRequest(
                token,
                object : GraphRequest.GraphJSONObjectCallback {
                    override fun onCompleted(`object`: JSONObject?, response: GraphResponse?) {
                        Log.e("LoginActivity", response.toString())

                        // Application code
                        try {

                            val userID = `object`!!.getString("id")
//                            birthday = `object`.getString("birthday") // 01/31/1980 format
                            val picture = "https://graph.facebook.com/$userID/picture?type=large"
                           val  name = `object`.getString("name")
                           val email = `object`.getString("email")
//                            val token =`object`.getString("")
//                            val mUser = RegisterRequestMdl(name = name,email = email,provider_id = userID,provider = "facebook")
//                            CompleteAccountActivity().startThisActivity(this@LoginActivity,mUser)
//                            finish()

                            val mUser = UserMdl(name,userID,email,picture)
                            mView.stopLoading()
                            mView.onSuccessLogin(mUser)

                        } catch (e: Exception) {
                            e.printStackTrace()
                        }

                    }
                })

        val parameters = Bundle()
        parameters.putString("fields", "id,name,email,gender,birthday,picture")
        request.parameters = parameters
        request.executeAsync()


    }


}