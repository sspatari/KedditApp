package com.example.strongheart.kedditapp.features.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.strongheart.kedditapp.R
import com.example.strongheart.kedditapp.commons.extensions.inflate
import kotlinx.android.synthetic.main.news_fragment.*

class NewsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true) // use this setting to improve performance
        news_list.layoutManager = LinearLayoutManager(context)

        initAdapter()
    }

    private fun initAdapter() {
        if(news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}