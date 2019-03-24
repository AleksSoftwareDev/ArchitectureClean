package me.mvvm.com.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Alexander Karpenko on 3/10/19.
 * java.karpenko@gmail.com
 */

@Entity(tableName = "user_property")
data class UserPublisherData(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @SerializedName("name") var name: String? = null,
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("url") var avatar: String? = null,
    @SerializedName("category") var group: String? = null)