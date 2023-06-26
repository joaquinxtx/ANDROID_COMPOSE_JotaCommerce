package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.data.repository.AuthRepositoryImpl
import com.joaquindev.jotacommerce.data.repository.UsersRepositoryImpl
import com.joaquindev.jotacommerce.data.repository.dataSource.AuthLocalDataSource
import com.joaquindev.jotacommerce.data.repository.dataSource.AuthRemoteDataSource
import com.joaquindev.jotacommerce.data.repository.dataSource.UsersRemoteDataSource
import com.joaquindev.jotacommerce.data.repository.dataSourceImpl.UsersRemoteDataSourceImpl
import com.joaquindev.jotacommerce.domain.repository.AuthRepository
import com.joaquindev.jotacommerce.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource,

        ): UserRepository = UsersRepositoryImpl(usersRemoteDataSource)

}