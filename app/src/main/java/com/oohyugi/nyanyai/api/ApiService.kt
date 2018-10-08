package com.oohyugi.nyanyai.api

import com.oohyugi.nyanyai.model.MusicModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
interface ApiService {

    @GET("track.search")
    fun searchArtist(@Query("q_artist") artist:String, @Query("page_size") pageSize:Int, @Query("page")page:Int, @Query("apikey") apiKey:String): Call<MusicModel.BaseMdl>
}