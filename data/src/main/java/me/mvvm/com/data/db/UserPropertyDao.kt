package me.mvvm.com.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import me.mvvm.com.data.entities.UserPublisherData

/**
 * Created by Alexander Karpenko on 3/10/19.
 * java.karpenko@gmail.com
 */
@Dao
interface UserPropertyDao {


    @Query("Select * from user_property")
    fun getAllPropertys(): Flowable<List<UserPublisherData>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllProperty(property: List<UserPublisherData>)

    @Query("DELETE FROM user_property")
    fun clear()
}