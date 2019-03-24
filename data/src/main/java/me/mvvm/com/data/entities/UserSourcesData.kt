package me.mvvm.com.data.entities

import com.google.gson.annotations.SerializedName
import me.mvvm.com.domain.entities.UserPublisherEntity
import me.mvvm.com.domain.entities.UserSourcesEntity

/**
 * Created by Alexander Karpenko on 3/10/19.
 * java.karpenko@gmail.com
 */
data class UserSourcesData(
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("user_property")
    var user_property: List<UserPublisherData> = emptyList()
)

class UserDataEntityMapper constructor() {

    fun mapToEntity(data: UserSourcesData?): UserSourcesEntity? = UserSourcesEntity(
        status = data?.status,
        userProperty = mapListUserToEntity(data?.user_property)
    )

    fun mapToEntity(users: List<UserPublisherData>?): UserSourcesEntity? = UserSourcesEntity(
        userProperty = mapListUserToEntity(users)
    )

    fun mapListUserToEntity(userProperty: List<UserPublisherData>?)
            : List<UserPublisherEntity> = userProperty?.map { mapUserEntity(it) } ?: emptyList()

    fun mapUserEntity(response: UserPublisherData): UserPublisherEntity = UserPublisherEntity(
        id = response.id,
        name = response.name,
        description = response.firstName,
        url = response.avatar,
        category = response.group
    )


}


class UsersEntityDataMapper constructor() {

    fun mapToEntity(data: UserSourcesEntity?): UserSourcesData? = UserSourcesData(
        status = data?.status,
        user_property = mapListUserToEntity(data?.userProperty)
    )

    fun mapListUserToEntity(articles: List<UserPublisherEntity>?)
            : List<UserPublisherData> = articles?.map { mapUserToEntity(it) } ?: emptyList()

    fun mapUserToEntity(response: UserPublisherEntity): UserPublisherData = UserPublisherData(
        id = response.id,
        name = response.name,
        firstName = response.description,
        avatar = response.url,
        group = response.category
    )


}

