package me.mvvm.com.myapplication.common

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.mvvm.com.domain.common.FlowableRxTransformer
import org.reactivestreams.Publisher
/**
 * Created by Alexander Karpenko on 3/8/19.
 * java.karpenko@gmail.com
 */
class AsyncFlowableTransformer<T> : FlowableRxTransformer<T>() {
    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}