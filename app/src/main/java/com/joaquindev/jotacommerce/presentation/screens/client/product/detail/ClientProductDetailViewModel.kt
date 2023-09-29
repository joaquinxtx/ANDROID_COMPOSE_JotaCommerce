package com.joaquindev.jotacommerce.presentation.screens.client.product.detail


import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.domain.model.ShoppingBagProduct
import com.joaquindev.jotacommerce.domain.useCase.shopping_bag.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductDetailViewModel @Inject constructor(
    private val shoppingBagUseCase: ShoppingBagUseCase,
     savedStateHandle: SavedStateHandle
) : ViewModel() {
    var data = savedStateHandle.get<String>("product")
    var product = Product.fromJson(data!!)
    var productImages = listOf(product.image1 ?: "", product.image2 ?: "")

    var quantity by mutableStateOf(0)
        private set
    var price by mutableStateOf(0.0)
        private set
    init {
        getShoppingBagProduct()
    }

    fun add() {
        quantity += 1
        price = product.price * quantity
    }

    fun remove() {
        if (quantity > 0) {
            quantity -= 1
            price = product.price * quantity
        }
    }

    private fun getShoppingBagProduct() = viewModelScope.launch {
       val result = shoppingBagUseCase.findById(product.id?:"")
        quantity = result?.quantity ?: 0
        price = product.price * quantity
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