package com.joaquindev.jotacommerce.presentation.screens.address.create

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClientAddressCreateViewModel @Inject constructor() : ViewModel(){

    var state by mutableStateOf(ClientAddressCreateState())
    private set


    fun onAddressInput(address:String){
        state = state.copy(address = address)
    }
    fun onNeighborhoodInput(neighborhood:String){
        state = state.copy(neighborhood = neighborhood)
    }

}