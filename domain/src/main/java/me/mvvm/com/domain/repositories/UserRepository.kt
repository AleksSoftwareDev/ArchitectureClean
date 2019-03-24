package me.mvvm.com.domain.repositories

import io.reactivex.Flowable
import me.mvvm.com.domain.entities.UserSourcesEntity

/**
 * Created by Alexander Karpenko on 3/9/19.
 * java.karpenko@gmail.com
 */
interface UserRepository {

    fun getUser() : Flowable<UserSourcesEntity>
    fun getLocalUser() : Flowable<UserSourcesEntity>
    fun getRemoteUser(): Flowable<UserSourcesEntity>
}