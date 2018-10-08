package com.oohyugi.nyanyai.data.search_artist_repo

import com.oohyugi.nyanyai.base.BaseRequest
import com.oohyugi.nyanyai.model.MusicModel

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
interface SearchArtistRepoReq:BaseRequest {

    fun callApiSearch(artistName:String, callback: BaseRequest.LoadDataCallback<MusicModel.BaseMdl>)
}