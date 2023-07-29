package com.joaquindev.jotacommerce.presentation.screens.client.product.detail

import android.util.Log
import androidx.compose.runtime.*

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.domain.model.ShoppingBagProduct
import com.joaquindev.jotacommerce.domain.useCase.shopping_bag.FindAllShoppingBagUseCase
import com.joaquindev.jotacommerce.domain.useCase.shopping_bag.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductDetailViewModel @Inject constructor(
    private val shoppingBagUseCase: ShoppingBagUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var data = savedStateHandle.get<String>("product")
    var product = Product.fromJson(data!!)
    var productImages = listOf<String>(product.image1 ?: "", product.image2 ?: "")

    var quantity by mutableStateOf(0)
        private set
    init {
        getShoppingBag()
    }

    fun add() {
        quantity += 1
    }

    fun remove() {
        if (quantity > 0) {
            quantity -= 1
        }
    }

    fun getShoppingBag() = viewModelScope.launch {
        shoppingBagUseCase.findAll().collect(){
            Log.d("ViewModelProducClient" , "Data: ${it}")
        }
    }

    fun saveItem() = viewModelScope.launch {
        if (quantity > 0 ){
            val shoppingBagProduct = ShoppingBagProduct(
                id = product.id ?: "",
                name = product.name,
                price = product.price,
                image1 = product.image1 ?: "",
                idCategory = product.idCategory,
                quantity = quantity

            )
            shoppingBagUseCase.add(shoppingBagProduct)

        }
    }

}