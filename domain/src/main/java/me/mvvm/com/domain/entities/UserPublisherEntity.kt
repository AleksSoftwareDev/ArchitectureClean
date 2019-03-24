package me.mvvm.com.domain.entities

/**
 * Created by Alexander Karpenko on 3/8/19.
 * java.karpenko@gmail.com
 */
data class UserPublisherEntity(
    var id: Int,
    var name: String? = null,
    var description: String? = null,
    var url: String? = null,
    var category: String? = null)