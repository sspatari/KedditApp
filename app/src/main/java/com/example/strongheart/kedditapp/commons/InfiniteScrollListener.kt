package com.example.strongheart.kedditapp.commons

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

class InfiniteScrollListener(
        val func: () -> Unit,
        val layoutMananger: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    private var previousTotal = 0
    private var loading = true
    private var visibleThreshold = 2
    private var firstVisibleItem = 0
    private var visibleItemCount = 0
    private var totalItemCount = 0


    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if(dy > 0) {
            visibleItemCount = recyclerView.childCount
            totalItemCount = layoutMananger.itemCount
            firstVisibleItem = layoutMananger.findFirstVisibleItemPosition()

            if(loading && totalItemCount > previousTotal) { //means the request has ended and new news where fetched
                loading = false
                previousTotal = totalItemCount
            }
            if(!loading && firstVisibleItem + visibleItemCount + visibleThreshold >= totalItemCount) {
                Log.i("InfinitScrollListener", "End reached")
                func()
                loading = true
            }
        }
    }
}