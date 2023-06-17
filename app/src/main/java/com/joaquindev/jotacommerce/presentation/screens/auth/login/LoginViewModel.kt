package com.joaquindev.jotacommerce.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch

import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    var stateForm by mutableStateOf(LoginState())
        private set

    var isValidForm by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf("")


    //LOGIN RESPONSE
    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(value = null)
        private set

    fun login() = viewModelScope.launch {
        if (isValidForm2()) {
            loginResponse = Resource.Loading
            val result = authUseCase.login(stateForm.email, stateForm.password)
            loginResponse = result

        }
    }

    fun onEmailInput(email: String) {
        stateForm = stateForm.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        stateForm = stateForm.copy(password = password)
    }


    fun isValidForm2(): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(stateForm.email).matches()) {
            errorMessage = "El email no es valido"
            return false
        } else if (stateForm.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracterres"
            return false
        }
        return true

    }

}