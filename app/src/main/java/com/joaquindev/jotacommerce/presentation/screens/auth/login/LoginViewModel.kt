package com.joaquindev.jotacommerce.presentation.screens.auth.login


import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set
    var errorMessage by mutableStateOf("")
    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set
    init {
        getSessionData()
    }
    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect { data ->
            Log.d("LoginViewModel", "Data: ${data.toJson()}")
            if (!data.token.isNullOrBlank()) {
                loginResponse = Resource.Success(data)
            }
        }
    }
    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }
    fun login() = viewModelScope.launch {
        if (isValidForm()) {
            loginResponse = Resource.Loading
            val result = authUseCase.login(state.email, state.password)
            loginResponse = result
        }
    }
    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }
    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }
    private fun isValidForm(): Boolean  {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "The email is not valid"
            return false
        }
        else if (state.password.length < 6) {
            errorMessage = "The password must be at least 6 characters"
            return false
        }
        return true
    }
}