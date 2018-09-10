package com.example.strongheart.kedditapp.features.news

import com.example.strongheart.kedditapp.api.RestApi
import com.example.strongheart.kedditapp.commons.RedditNews
import com.example.strongheart.kedditapp.commons.RedditNewsItem
import io.reactivex.Observable

/**
 * News Manager allows you to request news from Reddit Api.
 */

class NewsManager(private val api: RestApi = RestApi()) {
    /**
     * Returns Reddit News paginated by the given limit.
     *
     * @param after indicated the next page to navigate.
     * @param limit the number of news to request.
     */
    fun getNews(after: String, limit: String = "10") : Observable<RedditNews> {
        return Observable.create {
            emmitter ->

            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()

            if(response.isSuccessful) {
                val dataResponse = response.body()!!.data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news
                )
                emmitter.onNext(redditNews)
                emmitter.onComplete()
            } else {
                emmitter.onError(Throwable(response.message()))
            }
        }
    }
}