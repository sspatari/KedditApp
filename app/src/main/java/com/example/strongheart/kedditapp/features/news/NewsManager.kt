package com.example.strongheart.kedditapp.features.news

import com.example.strongheart.kedditapp.api.RestApi
import com.example.strongheart.kedditapp.commons.RedditNewsItem
import io.reactivex.Observable

class NewsManager(private val api: RestApi = RestApi()) {

    fun getNews(limit: String = "10") : Observable<List<RedditNewsItem>> {
        return Observable.create {
            emmitter ->

            val callResponse = api.getNews("", limit)
            val response = callResponse.execute()

            if(response.isSuccessful) {
                val news = response.body()!!.data.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                emmitter.onNext(news)
                emmitter.onComplete()
            } else {
                emmitter.onError(Throwable(response.message()))
            }
        }
    }
}