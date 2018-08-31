package com.example.strongheart.kedditapp.features.news

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.strongheart.kedditapp.R
import com.example.strongheart.kedditapp.commons.RedditNewsItem
import com.example.strongheart.kedditapp.commons.adapter.ViewType
import com.example.strongheart.kedditapp.commons.adapter.ViewTypeDelegateAdapter
import com.example.strongheart.kedditapp.commons.extensions.getFriendlyTime
import com.example.strongheart.kedditapp.commons.extensions.inflate
import com.example.strongheart.kedditapp.commons.extensions.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

class NewsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup)= TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)) {

        fun bind(item: RedditNewsItem) = with(itemView) {
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }
}