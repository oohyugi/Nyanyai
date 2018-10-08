package com.oohyugi.nyanyai.view.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oohyugi.nyanyai.R
import com.oohyugi.nyanyai.helper.inflate
import com.stickearn.stickpass.base.BaseFragment

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
class CreateFragment:BaseFragment() {


    companion object {
        fun newsInstance():CreateFragment{
            val bundle = Bundle()
            val fragment = CreateFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container!!.inflate(R.layout.create_fragment)
    }
}