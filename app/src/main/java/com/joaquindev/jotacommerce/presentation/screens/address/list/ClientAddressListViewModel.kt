package com.joaquindev.jotacommerce.presentation.screens.address.list

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Address
import com.joaquindev.jotacommerce.domain.useCase.address.AddressUseCase
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientAddressListViewModel @Inject constructor(
    private val addressUseCase: AddressUseCase,
    private val authUseCase: AuthUseCase
    ) : ViewModel() {

    var addressResponse by mutableStateOf<Resource<List<Address>>?>(null)

    fun getSessionData() = viewModelScope.launch {
        val user = authUseCase.getSessionData().first().user
        getAddress(user?.id ?: "")
    }

    fun getAddress( idUser:String)= viewModelScope.launch{
        addressResponse=Resource.Loading
        addressUseCase.findByUserAddress(idUser).collect(){
            Log.d("ClientAddressListViewModel", "data ${it}")
            addressResponse = it
        }
    }
}