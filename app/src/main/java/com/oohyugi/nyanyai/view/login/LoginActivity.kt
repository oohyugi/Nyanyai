package com.oohyugi.nyanyai.view.login

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.gson.Gson
import com.oohyugi.nyanyai.MainActivity
import com.oohyugi.nyanyai.R
import com.oohyugi.nyanyai.helper.PrefHelper
import com.oohyugi.nyanyai.model.UserMdl
import kotlinx.android.synthetic.main.login_activity.*
import kotlinx.android.synthetic.main.progress_dialog.*
import java.util.*

class LoginActivity : AppCompatActivity(), LoginView {
    override fun onSuccessLogin(mUser: UserMdl) {
        Log.e("success",Gson().toJson(mUser))
        PrefHelper.saveLoggedUser(this,mUser)
        MainActivity.startThisActivity(this)
    }

    override fun showLoading() {
        progress_dialog.visibility=View.VISIBLE
    }

    override fun errorLoading(errorMessage: String?) {

    }

    override fun stopLoading() {
        progress_dialog.visibility=View.GONE

    }


    var callbackManager: CallbackManager? = null
    var permissionNeeds = Arrays.asList("public_profile, email, user_birthday")
    var mGoogleApiClient: GoogleApiClient? = null
    private val RC_SIGN_IN = 11
    lateinit var mPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        mPresenter = LoginPresenter(this)
        callbackManager = CallbackManager.Factory.create()
        configurasiGoogleSign()
        handleClick()
    }

    private fun handleClick() {
        btnFacebook.setOnClickListener{
            mPresenter.loginWithFB(this,callbackManager,permissionNeeds)
        }
        btnGoogle.setOnClickListener {

            val signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
    }

    private fun configurasiGoogleSign() {
        //CONFIGURASI GOOGLE LOGIN
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleApiClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this) { connectionResult -> Log.wtf("onConnectionFailed: ", connectionResult.errorMessage!!) }
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager!!.onActivityResult(requestCode, resultCode, data)
        if (requestCode === RC_SIGN_IN) {
            try {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                val account = task.getResult(ApiException::class.java)
                val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
                Log.wtf("onActivityResult: ", Gson().toJson(account))

               val mUser = UserMdl(account!!.displayName, account.id!!, account.email,account.photoUrl.toString())
                PrefHelper.saveLoggedUser(this,mUser)
                MainActivity.startThisActivity(this)

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    companion object {
        fun startThisActivity(context:Context){
            val intent = Intent(context,LoginActivity::class.java)
            context.startActivity(intent)
        }
    }
}
