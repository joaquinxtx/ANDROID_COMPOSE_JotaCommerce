package com.joaquindev.jotacommerce.presentation.screens.client.product.list

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.domain.useCase.product.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductListViewModel @Inject constructor(private val productUseCase: ProductUseCase) :
    ViewModel() {

        var productResponse by mutableStateOf<Resource<List<Product>>?>(null)
    private set
    init {
        getProducts()
    }

    private fun getProducts() = viewModelScope.launch {
        productResponse = Resource.Loading
        productUseCase.findAll().collect(){
            productResponse = it
        }
    }
}