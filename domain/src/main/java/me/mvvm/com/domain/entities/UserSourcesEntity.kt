package me.mvvm.com.domain.entities

/**
 * Created by Alexander Karpenko on 3/8/19.
 * java.karpenko@gmail.com
 */
data class UserSourcesEntity (
    var status: String? = null,
    var userProperty: List<UserPublisherEntity> = emptyList())
