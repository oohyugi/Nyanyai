package com.oohyugi.nyanyai.view.find

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.oohyugi.nyanyai.R
import com.oohyugi.nyanyai.model.MusicModel
import com.oohyugi.nyanyai.view.find.AdapterTrack.ViewHolder

/**
 * Created by oohyugi on 09/10/18.
 * github: https://github.com/oohyugi
 */
class AdapterTrack(private val context: Context, private val list: List<MusicModel.TrackListItemMdl>) : RecyclerView.Adapter<AdapterTrack.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        var tvArtist = itemView.findViewById<TextView>(R.id.tvArtist)
        var tvId = itemView.findViewById<TextView>(R.id.tvId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.item_track, parent, false)


        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (track) = list[position]

        holder.tvId.text=track.trackId.toString()
        holder.tvTitle.text=track.trackName
        holder.tvArtist.text=track.artistName
    }


    override fun getItemCount(): Int {
        return list.size
    }

    companion object {

        private val TAG = AdapterTrack::class.java.simpleName
    }


}