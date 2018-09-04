package com.example.strongheart.kedditapp.features.news

import com.example.strongheart.kedditapp.commons.RedditNewsItem
import io.reactivex.Observable

class NewsManager {

    fun getNews() : Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriber ->

            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i, // number of comments
                        1457207701L - i * 200, // time
                        "https://picsum.photos/200/200?image=$i", // image url
                        "url"
                ))
            }
            subscriber.onNext(news)
        }
    }
}