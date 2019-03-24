package me.mvvm.com.domain.common

import io.reactivex.FlowableTransformer

/**
 * Created by Alexander Karpenko on 3/9/19.
 * java.karpenko@gmail.com
 */
abstract class FlowableRxTransformer<T>: FlowableTransformer<T,T>