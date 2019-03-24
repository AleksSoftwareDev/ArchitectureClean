package me.mvvm.com.myapplication.entites

/**
 * Created by Alexander Karpenko on 3/8/19.
 * java.karpenko@gmail.com
 */
data class UserSources(
    var status: String? = null,
    var articles: List<UserPublisher> = emptyList()
)