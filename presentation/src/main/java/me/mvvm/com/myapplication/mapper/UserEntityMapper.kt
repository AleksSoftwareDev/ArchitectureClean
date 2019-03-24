package me.mvvm.com.myapplication.mapper

import me.mvvm.com.domain.common.Mapper
import me.mvvm.com.domain.entities.UserPublisherEntity
import me.mvvm.com.domain.entities.UserSourcesEntity
import me.mvvm.com.myapplication.entites.UserPublisher
import me.mvvm.com.myapplication.entites.UserSources

/**
 * Created by Alexander Karpenko on 3/8/19.
 * java.karpenko@gmail.com
 */
class UserEntityMapper : Mapper<UserSourcesEntity, UserSources>() {
    override fun mapFrom(data: UserSourcesEntity): UserSources = UserSources(
        status = data.status,
        articles = mapListArticlesToPresetation(data.userProperty)
    )

    private fun mapListArticlesToPresetation(articles: List<UserPublisherEntity>?)
            : List<UserPublisher> = articles?.map { mapArticleToPresentation(it) }
        ?: emptyList()

    private fun mapArticleToPresentation(response: UserPublisherEntity): UserPublisher = UserPublisher(
        id = response.id,
        name = response.name,
        description = response.description,
        url = response.url,
        category = response.category
    )

}