package me.mvvm.com.domain.common

/**
 * Created by Alexander Karpenko on 3/8/19.
 * java.karpenko@gmail.com
 */
abstract class Mapper<in T,E>{

    abstract fun mapFrom(from: T): E

    fun Flowable(from: T) = io.reactivex.Flowable.fromCallable { mapFrom(from) }

    fun Flowable(from: List<T>) = io.reactivex.Flowable.fromCallable { from.map { mapFrom(it) } }
}