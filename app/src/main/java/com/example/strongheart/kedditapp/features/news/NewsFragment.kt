package com.example.strongheart.kedditapp.features.news

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.strongheart.kedditapp.R
import com.example.strongheart.kedditapp.commons.RxBaseFragment
import com.example.strongheart.kedditapp.commons.extensions.inflate
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.news_fragment.*

class NewsFragment: RxBaseFragment() {

    private val newsManager by lazy { NewsManager() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true) // use this setting to improve performance
        news_list.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if(savedInstanceState == null) {
            requestNews()
        }
    }

    private fun requestNews() {
        val disposable = newsManager.getNews()
                .subscribeOn(Schedulers.io()) // executes requests on another thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retrivedNews ->
                            (news_list.adapter as NewsAdapter).addNews(retrivedNews)
                        },
                        { e ->
                            Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                        }
                )
        disposables.add(disposable)
    }

    private fun initAdapter() {
        if(news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}