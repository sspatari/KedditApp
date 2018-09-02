package com.example.strongheart.kedditapp.commons

import com.example.strongheart.kedditapp.commons.adapter.AdapterConstants
import com.example.strongheart.kedditapp.commons.adapter.ViewType

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}