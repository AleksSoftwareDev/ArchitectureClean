package me.mvvm.com.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_item.view.*
import me.mvvm.com.myapplication.R
import me.mvvm.com.myapplication.entites.UserPublisher

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.NewsViewHolder>() {

    var usersProps = mutableListOf<UserPublisher>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usersProps.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(usersProps[position])
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(newsPublisherItem: UserPublisher) {
            with(itemView) {
                heading.text = newsPublisherItem.description
                user_url.text = newsPublisherItem.url
            }
        }
    }

    fun updateList(list: List<UserPublisher>) {
        if (list.isNotEmpty()) {
            usersProps.clear()
            usersProps.addAll(list)
            notifyDataSetChanged()
        }
    }
}