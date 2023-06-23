package com.joaquindev.jotacommerce.presentation.screens.profile.update

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val  savedStateHandle: SavedStateHandle,
    ) :
    ViewModel() {


    var state by mutableStateOf(ProfileUpdateState())
        private set

    //Arguments
    val data = savedStateHandle.get<String>("user")
    val user = User.fromJson(data!!)


    init {
        state = state.copy(
            name= user.name,
            lastname = user.lastname,
            email = user.email,
            phone = user.phone,
            image = user.image ?: ""
        )
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onLastNameInput(lastName: String) {
        state = state.copy(lastname = lastName)
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }
    fun onImageInput(image: String) {
        state = state.copy(image = image)
    }

    fun onPhoneInput(phone: String) {
        state = state.copy(phone = phone)
    }
}