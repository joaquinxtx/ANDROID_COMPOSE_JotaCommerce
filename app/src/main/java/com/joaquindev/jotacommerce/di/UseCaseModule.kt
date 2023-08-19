package com.joaquindev.jotacommerce.di

import com.joaquindev.jotacommerce.domain.repository.*
import com.joaquindev.jotacommerce.domain.useCase.address.AddressUseCase
import com.joaquindev.jotacommerce.domain.useCase.address.CreateAddressUseCase
import com.joaquindev.jotacommerce.domain.useCase.address.FindByUserAddressUseCase
import com.joaquindev.jotacommerce.domain.useCase.auth.*
import com.joaquindev.jotacommerce.domain.useCase.catgeories.*
import com.joaquindev.jotacommerce.domain.useCase.product.*
import com.joaquindev.jotacommerce.domain.useCase.shopping_bag.*
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
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository)
    )

    @Provides
    fun provideUsersUseCase(usersRepository: UserRepository) = UsersUseCase(
        updateUser = UpdateUserUseCase(usersRepository),
        updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
    )

    @Provides
    fun provideCategoriesUseCase(categoriesRepository: CategoriesRepository) = CategoriesUseCase(
        createCategory = CreateCategoryUseCase(categoriesRepository),
        getCategories = GetCategoriesUseCase(categoriesRepository),
        updateCategory = UpdateCategoryUseCase(categoriesRepository),
        updateCategoryWidthImage = UpdateCategoryWidthImageUseCase(categoriesRepository),
        deleteCategory = DeleteCategoryUseCase(categoriesRepository)

    )

    @Provides
    fun provideProductUseCase(productRepository: ProductRepository) = ProductUseCase(
        createProduct = CreateProductUseCase(productRepository),
        findByCategory = FindByCategoryUseCase(productRepository),
        updateProduct = UpdateProductUseCase(productRepository),
        updateProductWithImage = UpdateProductWithImageUseCase(productRepository),
        deleteProduct = DeleteProductUseCase(productRepository),
        findAll = FindAllUseCase(productRepository)
    )

    @Provides
    fun provideShoppingBagUseCase(shoppingBagRepository: ShoppingBagRepository) =
        ShoppingBagUseCase(
            add = AddUseCase(shoppingBagRepository),
            delete = DeleteUseCase(shoppingBagRepository),
            findAll = FindAllShoppingBagUseCase(
                shoppingBagRepository
            ),
            findById = FindByIdShoppingBagUseCase(shoppingBagRepository)
        )

    @Provides
    fun provideAddressUseCase(addressRepository: AddressRepository) =
        AddressUseCase(
            createAddress = CreateAddressUseCase(addressRepository),
            findByUserAddress = FindByUserAddressUseCase(addressRepository)
        )
}