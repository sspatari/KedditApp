package com.example.strongheart.kedditapp.features.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.strongheart.kedditapp.R
import com.example.strongheart.kedditapp.commons.inflate
import kotlinx.android.synthetic.main.news_fragment.*

class NewsFragment: Fragment() {

    private val newsList by lazy {
        news_list
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        newsList.setHasFixedSize(true) // use this setting to improve performance
        newsList.layoutManager = LinearLayoutManager(context)
    }
}