package com.raduldul.rajagaluhkidul.hilt

import android.app.Application
import com.raduldul.rajagaluhkidul.database_room.MainDatabase
import com.raduldul.rajagaluhkidul.database_room.UserDAO
import com.raduldul.rajagaluhkidul.datastore_preferences.UserManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideUserManager(application: Application): UserManager {
        return UserManager.getInstance(application)
    }

    @Singleton
    @Provides
    fun providesMainDatabase(application: Application): MainDatabase {
        return MainDatabase.getInstance(application)!!
    }

    @Singleton
    @Provides
    fun providesUserDao(userDao:MainDatabase): UserDAO {
        return userDao.userDao()
    }
}