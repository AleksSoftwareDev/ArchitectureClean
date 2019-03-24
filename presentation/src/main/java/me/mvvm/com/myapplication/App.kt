package me.mvvm.com.myapplication

import android.app.Application
import me.mvvm.com.myapplication.di.*
import org.koin.android.ext.android.startKoin

/**
 * Created by Alexander Karpenko on 3/9/19.
 * java.karpenko@gmail.com
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        loadKoin()
    }

    private fun loadKoin() {
        startKoin(this,
            listOf(mNetwokModule,
                mViewModels,
                mRepoModule,
                mUseCaseModules,
                mLocalModules)

        )
    }
}