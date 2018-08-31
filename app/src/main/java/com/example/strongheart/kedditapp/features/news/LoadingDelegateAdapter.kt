package com.example.strongheart.kedditapp.features.news

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.strongheart.kedditapp.R
import com.example.strongheart.kedditapp.commons.adapter.ViewType
import com.example.strongheart.kedditapp.commons.adapter.ViewTypeDelegateAdapter
import com.example.strongheart.kedditapp.commons.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading))

}