package me.mvvm.com.domain.common

import io.reactivex.Flowable

/**
 * Created by Alexander Karpenko on 3/10/19.
 * java.karpenko@gmail.com
 */
abstract class BaseFlowableUseCase<T>(private  val transformer: FlowableRxTransformer<T>) {

    abstract fun createFlowable(data: Map<String, Any>? = null): Flowable<T>

    fun single(withData: Map<String, Any>? = null) : Flowable<T>{
        return createFlowable(withData).compose(transformer)
    }
}