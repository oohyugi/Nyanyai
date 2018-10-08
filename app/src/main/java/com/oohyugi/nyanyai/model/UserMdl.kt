package com.oohyugi.nyanyai.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
data class UserMdl
(

 @SerializedName("name")
 var name: String? = null,
 @SerializedName("id")
 var id: String = "",
 @SerializedName("email")
 var email: String?=null,
 @SerializedName("picture_profile")
 var imgProfile:String?=null

 ) :Serializable