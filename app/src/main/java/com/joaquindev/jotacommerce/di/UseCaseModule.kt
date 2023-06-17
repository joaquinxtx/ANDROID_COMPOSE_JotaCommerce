package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.domain.repository.AuthRepository
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase
import com.joaquindev.jotacommerce.domain.useCase.auth.LoginUseCase
import com.joaquindev.jotacommerce.domain.useCase.auth.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {


    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository)= AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository)
    )
}