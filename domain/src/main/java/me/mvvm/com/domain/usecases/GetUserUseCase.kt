package me.mvvm.com.domain.usecases

import io.reactivex.Flowable
import me.mvvm.com.domain.common.BaseFlowableUseCase
import me.mvvm.com.domain.common.FlowableRxTransformer
import me.mvvm.com.domain.entities.UserSourcesEntity
import me.mvvm.com.domain.repositories.UserRepository

/**
 * Created by Alexander Karpenko on 3/9/19.
 * java.karpenko@gmail.com
 */
class GetUserUseCase(transformer: FlowableRxTransformer<UserSourcesEntity>, private val repository: UserRepository) : BaseFlowableUseCase<UserSourcesEntity>(transformer) {

    override fun createFlowable(data : Map<String, Any>?): Flowable<UserSourcesEntity>{
        return repository.getUser()
    }

    fun getUser(): Flowable<UserSourcesEntity>{
        val data = HashMap<String, String>()
        return single(data)
    }
}