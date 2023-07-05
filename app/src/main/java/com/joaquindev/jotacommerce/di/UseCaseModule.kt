package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.domain.repository.AuthRepository
import com.joaquindev.jotacommerce.domain.repository.CategoriesRepository
import com.joaquindev.jotacommerce.domain.repository.UserRepository
import com.joaquindev.jotacommerce.domain.useCase.auth.*
import com.joaquindev.jotacommerce.domain.useCase.catgeories.CategoriesUseCase
import com.joaquindev.jotacommerce.domain.useCase.catgeories.CreateCategoryUseCase
import com.joaquindev.jotacommerce.domain.useCase.catgeories.GetCategoriesUseCase
import com.joaquindev.jotacommerce.domain.useCase.users.UpdateUserUseCase
import com.joaquindev.jotacommerce.domain.useCase.users.UpdateUserWithImageUseCase
import com.joaquindev.jotacommerce.domain.useCase.users.UsersUseCase
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
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository)
    )

    @Provides
    fun provideUsersUseCase(usersRepository:UserRepository)= UsersUseCase(
        updateUser = UpdateUserUseCase(usersRepository),
        updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
    )
    @Provides
    fun provideCategoriesUseCase(categoriesRepository: CategoriesRepository)= CategoriesUseCase(
        createCategory= CreateCategoryUseCase(categoriesRepository),
        getCategories = GetCategoriesUseCase(categoriesRepository)
    )
}