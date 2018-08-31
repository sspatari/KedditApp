package com.example.strongheart.kedditapp.features.news

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.strongheart.kedditapp.commons.adapter.AdapterConstants
import com.example.strongheart.kedditapp.commons.adapter.ViewType
import com.example.strongheart.kedditapp.commons.adapter.ViewTypeDelegateAdapter

class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        this.delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.NEWS, NewsDelegateAdapter())
        this.items = ArrayList()
        this.items.add(loadingItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return this.delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return this.items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        this.delegateAdapters.get(getItemViewType(position))!!.onBindViewHolder(holder, this.items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return this.items.get(position).getViewType()
    }
}