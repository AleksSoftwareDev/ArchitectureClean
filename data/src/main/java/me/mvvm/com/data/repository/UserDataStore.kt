package me.mvvm.com.data.repository

import io.reactivex.Flowable
import me.mvvm.com.domain.entities.UserSourcesEntity

/**
 * Created by Alexander Karpenko on 3/10/19.
 * java.karpenko@gmail.com
 */
interface UserDataStore {
    fun getUsers(): Flowable<UserSourcesEntity>
}