package com.oohyugi.nyanyai.view.find

import com.oohyugi.nyanyai.model.MusicModel
import com.stickearn.stickpass.base.BaseView

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
interface FindFragmentView: BaseView {
    fun showTrackData(trackList: List<MusicModel.TrackListItemMdl>?)
}