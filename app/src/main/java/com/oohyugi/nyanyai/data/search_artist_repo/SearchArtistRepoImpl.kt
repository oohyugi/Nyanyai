package com.oohyugi.nyanyai.data.search_artist_repo

import com.oohyugi.nyanyai.BuildConfig
import com.oohyugi.nyanyai.api.BaseCallBack
import com.oohyugi.nyanyai.base.BaseRepo
import com.oohyugi.nyanyai.base.BaseRequest
import com.oohyugi.nyanyai.model.MusicModel

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
class SearchArtistRepoImpl:BaseRepo(),SearchArtistRepoReq {
    override fun callApiSearch(artistName: String, callback: BaseRequest.LoadDataCallback<MusicModel.BaseMdl>) {
        mApiClient.getApiServices().searchArtist(artistName,1000,1,BuildConfig.API_KEY).enqueue(object : BaseCallBack<MusicModel.BaseMdl>() {
            override fun onError(errorMessage: String) {
                callback.onDataError(errorMessage)
            }

            override fun onSuccess(response: MusicModel.BaseMdl) {
                if (response.message.header.statusCode==200){
                    callback.onDataLoaded(response)
                }else{
                    callback.onDataError(response.message.header.statusCode.toString())
                }

            }

        })
    }
}