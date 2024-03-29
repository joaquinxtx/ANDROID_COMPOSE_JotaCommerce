package com.joaquindev.jotacommerce.presentation.screens.client.product.listByCategory


import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.domain.useCase.product.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductByCategoryListViewModel @Inject constructor(
    private val productUseCase: ProductUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    var data = savedStateHandle.get<String>("category")
    var category = Category.fromJson(data!!)

    var productsResponse by mutableStateOf<Resource<List<Product>>?>(null)
        private set


    init {
        getProducts()
    }

    private fun getProducts() = viewModelScope.launch {
        productsResponse = Resource.Loading
        productUseCase.findByCategory(category.id!!).collect { resource ->
            productsResponse = resource
            when (resource) {
                is Resource.Loading -> {
                    Log.d("ClientProductByCategory", "Data: Loading")
                }
                is Resource.Success -> {
                    Log.d("ClientProductByCategory", "Data: ${resource.data}")
                }
                is Resource.Failure-> {
                    Log.d("ClientProductByCategory", "Error: ${resource.message}")
                }
            }
        }
    }

}