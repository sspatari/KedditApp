package com.example.strongheart.kedditapp.api

class RedditNewsResponse(val data: RedditDataResponse)

class RedditDataResponse(
        val children: List<RedditChildrenResponse>,
        val after: String?,
        val before: String?
)

class RedditChildrenResponse(
        val author: String,
        val title: String,
        val num_comments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
)