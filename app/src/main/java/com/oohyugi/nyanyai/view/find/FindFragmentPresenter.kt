package com.oohyugi.nyanyai.view.find

import android.util.Log
import com.google.gson.Gson
import com.oohyugi.nyanyai.base.BaseRequest
import com.oohyugi.nyanyai.data.search_artist_repo.SearchArtistRepoImpl
import com.oohyugi.nyanyai.data.search_artist_repo.SearchArtistRepoReq
import com.oohyugi.nyanyai.model.MusicModel
import com.stickearn.stickpass.base.BasePresenter

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
class FindFragmentPresenter(mView: FindFragmentView) : BasePresenter<FindFragmentView>(mView) {

    val repo=SearchArtistRepoImpl()
    fun getDataArtist(artistName:String){
        mView.showLoading()
        repo.callApiSearch(artistName,object :BaseRequest.LoadDataCallback<MusicModel.BaseMdl>{
            override fun onDataLoaded(data: MusicModel.BaseMdl) {
                Log.e("data",Gson().toJson(data))
                mView.stopLoading()
                mView.showTrackData(data.message.body.trackList)
            }

            override fun onDataError(errorMessage: String) {
                Log.e("error",errorMessage)
                mView.stopLoading()
                mView.errorLoading(errorMessage)
            }

        })

    }
}