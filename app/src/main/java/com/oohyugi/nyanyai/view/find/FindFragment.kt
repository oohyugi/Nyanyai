package com.oohyugi.nyanyai.view.find

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.oohyugi.nyanyai.R
import com.oohyugi.nyanyai.helper.inflate
import com.oohyugi.nyanyai.model.MusicModel
import com.stickearn.stickpass.base.BaseFragment
import kotlinx.android.synthetic.main.find_fragment.*
import kotlinx.android.synthetic.main.progress_dialog.*

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
class FindFragment:BaseFragment(),FindFragmentView {
    override fun showTrackData(trackList: List<MusicModel.TrackListItemMdl>?) {
        mListTrack.addAll(trackList!!)
        mAdapterTrack.notifyDataSetChanged()
    }

    override fun showLoading() {
        progress_dialog.visibility=View.VISIBLE


    }

    override fun errorLoading(errorMessage: String?) {
        Toast.makeText(mContext,errorMessage,Toast.LENGTH_LONG).show()
    }

    override fun stopLoading() {
        progress_dialog.visibility=View.GONE
    }


    companion object {
        fun newsInstance():FindFragment{
            val bundle = Bundle()
            val fragment = FindFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    lateinit var mPresenter: FindFragmentPresenter
    lateinit var mAdapterTrack: AdapterTrack
     var mListTrack:MutableList<MusicModel.TrackListItemMdl> = mutableListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListTrack()
        mPresenter = FindFragmentPresenter(this)
        mPresenter.getDataArtist("justin")



    }

    private fun setupListTrack() {
        rvTrack.layoutManager=LinearLayoutManager(mContext)
        mAdapterTrack = AdapterTrack(mContext,mListTrack)
        rvTrack.adapter = mAdapterTrack
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container!!.inflate(R.layout.find_fragment)
    }
}