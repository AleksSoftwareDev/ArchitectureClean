package me.mvvm.com.data.api

import io.reactivex.Flowable
import me.mvvm.com.data.entities.UserSourcesData
import retrofit2.http.GET

/**
 * Created by Alexander Karpenko on 3/10/19.
 * java.karpenko@gmail.com
 */
interface RemoteUserApi {

    @GET("33f06052-3dce-4697-a3d9-7ffe1c21a413")
    fun getUsers(): Flowable<UserSourcesData>

}