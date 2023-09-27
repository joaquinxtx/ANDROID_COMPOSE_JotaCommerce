package com.joaquindev.jotacommerce.presentation.screens.client.shopping_bag

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.model.ShoppingBagProduct
import com.joaquindev.jotacommerce.domain.useCase.shopping_bag.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ClientShoppingBagViewModel @Inject constructor(
    private val shoppingBagUseCase: ShoppingBagUseCase
) : ViewModel() {

    var shoppingBag = mutableStateListOf<ShoppingBagProduct>()
        private set

    var total by mutableStateOf(0.0)
        private set



    fun getTotal() {
        total = 0.0
        shoppingBag.forEach {
            total += (it.price * it.quantity)
        }
    }

     fun getShoppingBag() = viewModelScope.launch {
        shoppingBagUseCase.findAll().collect {
            shoppingBag.clear()
            shoppingBag.addAll(it)
            getTotal()
        }
    }

    fun addItem(shoppingBagProduct: ShoppingBagProduct) = viewModelScope.launch {
        shoppingBagProduct.quantity = shoppingBagProduct.quantity + 1
        shoppingBagUseCase.add(shoppingBagProduct)
    }

    fun subtractItem(shoppingBagProduct: ShoppingBagProduct) = viewModelScope.launch {
        if (shoppingBagProduct.quantity > 1) {
            shoppingBagProduct.quantity = shoppingBagProduct.quantity - 1
            shoppingBagUseCase.add(shoppingBagProduct)
            getTotal()

        }
    }

    fun removeItem(id: String) = viewModelScope.launch {
        shoppingBagUseCase.delete(id)
        getTotal()
    }


}


