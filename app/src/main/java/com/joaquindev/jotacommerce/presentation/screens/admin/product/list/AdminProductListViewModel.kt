package com.joaquindev.jotacommerce.presentation.screens.admin.product.list


import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase
import com.joaquindev.jotacommerce.domain.useCase.product.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminProductListViewModel @Inject constructor(
    private val productUseCase: ProductUseCase,
    savedStateHandle: SavedStateHandle,
    private val authUseCase: AuthUseCase
) :
    ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set

    var data = savedStateHandle.get<String>("category")
    var category = Category.fromJson(data!!)

    var productsResponse by mutableStateOf<Resource<List<Product>>?>(null)
        private set

    var productsDeleteResponse by mutableStateOf<Resource<Unit>?>(null)
        private set

    init {
        getProducts()
        getSessionData()
    }
    fun getSessionData()= viewModelScope.launch {
        authUseCase.getSessionData().collect{ data ->
            user = data.user
        }
    }

    private fun getProducts() = viewModelScope.launch {
        productsResponse = Resource.Loading
        productUseCase.findByCategory(category.id!!).collect {
            productsResponse = it
        }
    }

    fun deleteProduct(id: String) = viewModelScope.launch {
        productsDeleteResponse = Resource.Loading
        val result = productUseCase.deleteProduct(id)
        productsDeleteResponse = result
    }
}