package me.mvvm.com.data.repository

import io.reactivex.Flowable
import me.mvvm.com.domain.entities.UserSourcesEntity
import me.mvvm.com.domain.repositories.UserRepository

/**
 * Created by Alexander Karpenko on 3/10/19.
 * java.karpenko@gmail.com
 */

class RepositoryImpl(private val remote: UserRemoteImpl, private val cache: UserCacheImpl) : UserRepository {

    override fun getLocalUser(): Flowable<UserSourcesEntity> {
        return cache.getUsers()
    }

    override fun getRemoteUser(): Flowable<UserSourcesEntity> {
        return remote.getUsers()
    }

    override fun getUser(): Flowable<UserSourcesEntity> {
        val updateUserFlowable = remote.getUsers()

        return cache.getUsers().mergeWith( updateUserFlowable.doOnNext{cache.savePropertyUser(it)}).doOnError { getLocalUser() }.doOnError { "Error" }
    }
}