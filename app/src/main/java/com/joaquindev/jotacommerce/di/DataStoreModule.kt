package com.joaquindev.jotacommerce.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.joaquindev.jotacommerce.core.Config.AUTH_PREFERENCE
import com.joaquindev.jotacommerce.data.dataSource.local.datastore.AuthDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    fun providePreferencesDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(produceFile = {
            context.preferencesDataStoreFile(AUTH_PREFERENCE)
        })

    @Provides
    @Singleton
    fun provideAuthDatastore( dataStore: DataStore<Preferences>)= AuthDataStore(dataStore)
}