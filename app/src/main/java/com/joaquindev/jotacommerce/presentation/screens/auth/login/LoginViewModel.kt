package com.joaquindev.jotacommerce.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var stateForm by mutableStateOf(LoginState())
        private set

    var isValidForm by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf("")
    private set

    fun onEmailInput(email: String) {
        stateForm = stateForm.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        stateForm = stateForm.copy(password = password)
    }

    fun validateForm()=viewModelScope.launch {
        if (!Patterns.EMAIL_ADDRESS.matcher(stateForm.email).matches()) {
            errorMessage = "El email no es valido"

        }
        else if (stateForm.password.length < 6){
            errorMessage = "La contraseña debe tener al menos 6 caracterres"
        }

        delay(3000)
        errorMessage=""


    }

}