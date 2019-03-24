package me.mvvm.com.myapplication.di

import androidx.room.Room
import me.mvvm.com.data.api.RemoteUserApi
import me.mvvm.com.data.db.UserDatabase
import me.mvvm.com.data.entities.UserDataEntityMapper
import me.mvvm.com.data.entities.UsersEntityDataMapper
import me.mvvm.com.data.repository.RepositoryImpl
import me.mvvm.com.data.repository.UserCacheImpl
import me.mvvm.com.data.repository.UserRemoteImpl
import me.mvvm.com.domain.repositories.UserRepository
import me.mvvm.com.domain.usecases.GetUserUseCase
import me.mvvm.com.myapplication.common.AsyncFlowableTransformer
import me.mvvm.com.myapplication.mapper.UserEntityMapper
import me.mvvm.com.myapplication.view.UserViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit

/**
 * Created by Alexander Karpenko on 3/6/19.
 * java.karpenko@gmail.com
 */

val mRepoModule = module {
    single(name = "local") {
        UserCacheImpl(
            database = get(DATABASE), entityToDataMapper = UsersEntityDataMapper(),
            dataToEntityMapper = UserDataEntityMapper()
        )
    }

    single(name = REMOTE) { UserRemoteImpl(api = get(API)) }

    single { RepositoryImpl(remote = get(REMOTE), cache = get("local")) as UserRepository }
}

val mUseCaseModules = module {
    factory(name = GET_USER_USECASE) { GetUserUseCase(transformer = AsyncFlowableTransformer(), repository = get()) }
}

val mNetwokModule = module {
    single(name = RETROFIT_INSTANCE) { createNetworkClient(BASE_URL) }
    single(name = API) { (get(RETROFIT_INSTANCE) as Retrofit).create(RemoteUserApi::class.java) }
}

val mLocalModules = module {
    single(name = DATABASE) {
        Room.databaseBuilder(androidApplication(), UserDatabase::class.java, "user_property").build()
    }
}

val mViewModels = module {
    viewModel {
        UserViewModel(getNewsUseCase = get(GET_USER_USECASE), mapper = UserEntityMapper())
    }
}

private const val BASE_URL = "https://webhook.site/"
private const val RETROFIT_INSTANCE = "Retrofit"
private const val API = "Api"
private const val GET_USER_USECASE = "GetUserUseCase"
private const val REMOTE = "remote response"
private const val DATABASE = "database"