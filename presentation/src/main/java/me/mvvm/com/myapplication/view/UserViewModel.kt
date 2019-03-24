package me.mvvm.com.myapplication.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import me.mvvm.com.domain.common.Mapper
import me.mvvm.com.domain.entities.UserSourcesEntity
import me.mvvm.com.domain.usecases.GetUserUseCase
import me.mvvm.com.myapplication.common.BaseViewModel
import me.mvvm.com.myapplication.entites.Data
import me.mvvm.com.myapplication.entites.Error
import me.mvvm.com.myapplication.entites.Status
import me.mvvm.com.myapplication.entites.UserSources

/**
 * Created by Alexander Karpenko on 3/10/19.
 * java.karpenko@gmail.com
 */
class UserViewModel (private val getNewsUseCase: GetUserUseCase,
                     private val mapper: Mapper<UserSourcesEntity, UserSources>
) : BaseViewModel() {

    companion object {
        private val TAG = "viewmodel"
    }

    var mUsers = MutableLiveData<Data<UserSources>>()

    fun fetchUser() {
        val disposable = getNewsUseCase.getUser()
            .flatMap { mapper.Flowable(it) }
            .subscribe({ response ->
                Log.d(TAG, "On Next Called")
                mUsers.value = Data(responseType = Status.SUCCESSFUL, data = response)
            }, { error ->
                Log.d(TAG, "On Error Called" + error.message)
                mUsers.value = Data(responseType = Status.ERROR, error = Error(error.message))
            }, {
                Log.d(TAG, "On Complete Called")
            })

        addDisposable(disposable)
    }

    fun getNewsLiveData() = mUsers
}