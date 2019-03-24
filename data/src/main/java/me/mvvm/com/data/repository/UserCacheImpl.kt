package me.mvvm.com.data.repository

import io.reactivex.Flowable
import me.mvvm.com.data.db.UserDatabase
import me.mvvm.com.data.db.UserPropertyDao
import me.mvvm.com.data.entities.UserDataEntityMapper
import me.mvvm.com.data.entities.UsersEntityDataMapper
import me.mvvm.com.domain.entities.UserSourcesEntity

/**
 * Created by Alexander Karpenko on 3/10/19.
 * java.karpenko@gmail.com
 */
class UserCacheImpl(private val database: UserDatabase,
                    private val entityToDataMapper: UsersEntityDataMapper,
                    private val dataToEntityMapper: UserDataEntityMapper
) : UserDataStore {

    private val dao: UserPropertyDao = database.getUserDao()

    override fun getUsers(): Flowable<UserSourcesEntity> {
        return dao.getAllPropertys().map { it ->
            dataToEntityMapper.mapToEntity(it)
        }
    }

    fun savePropertyUser(it: UserSourcesEntity) {
        dao.clear()
        dao.saveAllProperty(it.userProperty.map { property -> entityToDataMapper.mapUserToEntity(property) })
    }

}