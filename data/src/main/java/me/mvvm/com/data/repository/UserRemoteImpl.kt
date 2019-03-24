package me.mvvm.com.data.repository

import io.reactivex.Flowable
import me.mvvm.com.data.api.RemoteUserApi
import me.mvvm.com.data.entities.UserDataEntityMapper
import me.mvvm.com.domain.entities.UserSourcesEntity

/**
 * Created by Alexander Karpenko on 3/10/19.
 * java.karpenko@gmail.com
 */
class UserRemoteImpl constructor(private val api: RemoteUserApi): UserDataStore {

    private val userMapper = UserDataEntityMapper()

    override fun getUsers(): Flowable<UserSourcesEntity> {

        return api.getUsers().map { userMapper.mapToEntity(it) }
    }

}