package com.raduldul.rajagaluhkidul.database_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "table_user")
class UserData(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @ColumnInfo(name = "username")
    var username : String,
    @ColumnInfo(name = "email")
    var email : String,
    @ColumnInfo(name = "password")
    var password: String

) : java.io.Serializable