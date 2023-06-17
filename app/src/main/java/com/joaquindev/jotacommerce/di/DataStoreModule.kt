package com.joaquindev.jotacommerce.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.joaquindev.jotacommerce.core.Config.AUTH_PREFERENCE
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    fun providePreferencesDataStore(@ApplicationContext context: Context):DataStore<Preferences> = PreferenceDataStoreFactory.create( produceFile = {
        context.preferencesDataStoreFile(AUTH_PREFERENCE)
    })
}