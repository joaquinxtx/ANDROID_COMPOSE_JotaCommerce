package com.joaquindev.jotacommerce.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase
import com.joaquindev.jotacommerce.presentation.screens.auth.register.mapper.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    var stateForm by mutableStateOf(RegisterState())
        private set


    var errorMessage by mutableStateOf("")


    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(value = null)
        private set

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun register() = viewModelScope.launch {
        if (isValidForm()){

            registerResponse = Resource.Loading
            val result = authUseCase.register(stateForm.toUser())
            registerResponse = result

        }
    }

    fun onNameInput(name: String) {
        stateForm = stateForm.copy(name = name)
    }

    fun onLastNameInput(lastName: String) {
        stateForm = stateForm.copy(lastname = lastName)
    }

    fun onEmailInput(email: String) {
        stateForm = stateForm.copy(email = email)
    }

    fun onPhoneInput(phone: String) {
        stateForm = stateForm.copy(phone = phone)
    }

    fun onPasswordInput(password: String) {
        stateForm = stateForm.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String) {
        stateForm = stateForm.copy(confirmPassword = confirmPassword)
    }


    private fun isValidForm():Boolean  {
        if (stateForm.name == "") {
            errorMessage = "Enter the name"
            return false
        } else if (stateForm.lastname == "") {
            errorMessage = "Enter the last name"
            return false
        } else if (stateForm.phone == "") {
            errorMessage = "Enter the phone"
            return false
        } else if (stateForm.email == "") {
            errorMessage = "Enter the email"
            return false
        } else if (stateForm.password == "") {
            errorMessage = "Enter the password"
            return false
        } else if (stateForm.confirmPassword == "") {
            errorMessage = "Enter the confirmation password"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(stateForm.email).matches()) {
            errorMessage = "The email is not valid"
            return false
        } else if (stateForm.password.length < 6) {
            errorMessage = "\n" + "Password must be at least 6 characters"
            return false
        } else if (stateForm.password != stateForm.confirmPassword) {
            errorMessage = "Passwords do not match"
            return false
        }

        return true


    }


}