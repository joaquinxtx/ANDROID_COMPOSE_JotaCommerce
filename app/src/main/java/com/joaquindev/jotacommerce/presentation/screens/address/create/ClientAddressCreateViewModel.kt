package com.joaquindev.jotacommerce.presentation.screens.address.create

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Address
import com.joaquindev.jotacommerce.domain.useCase.address.AddressUseCase
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase
import com.joaquindev.jotacommerce.presentation.screens.address.create.mapper.toAddress
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientAddressCreateViewModel @Inject constructor(
    private val addressUseCase: AddressUseCase ,
    private  val authUseCase: AuthUseCase
    ) :
    ViewModel() {

    var state by mutableStateOf(ClientAddressCreateState())
        private set

    var addressResponse by mutableStateOf<Resource<Address>?>(null)

    fun getSessionData() = viewModelScope.launch {
        val user = authUseCase.getSessionData().first().user
        state = state.copy(idUser = user?.id ?: "")
    }

    fun createAddress() =viewModelScope.launch {
        addressResponse = Resource.Loading
        val result = addressUseCase.createAddress(state.toAddress())
        addressResponse = result
    }
    fun clearForm(){
        state = state.copy(
            address = "",
            neighborhood = ""
        )
        addressResponse=null
    }

    fun onAddressInput(address: String) {
        state = state.copy(address = address)
    }

    fun onNeighborhoodInput(neighborhood: String) {
        state = state.copy(neighborhood = neighborhood)
    }

}