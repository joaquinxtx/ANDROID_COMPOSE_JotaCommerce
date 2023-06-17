package com.joaquindev.jotacommerce.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    var stateForm by mutableStateOf(RegisterState())
        private set


    var errorMessage by mutableStateOf("")


    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(value = null)
        private set

    fun register() = viewModelScope.launch {
        if (isValidForm()){
            val user = User(
                name = stateForm.name,
                lastname = stateForm.lastname,
                phone = stateForm.phone,
                email = stateForm.email,
                password = stateForm.password,

                )
            registerResponse = Resource.Loading
            val result = authUseCase.register(user)
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


    fun isValidForm():Boolean  {
        if (stateForm.name == "") {
            errorMessage = "Ingresa el nombre"
            return false
        } else if (stateForm.lastname == "") {
            errorMessage = "Ingresa el apellido"
            return false
        } else if (stateForm.phone == "") {
            errorMessage = "Ingresa el telefono"
            return false
        } else if (stateForm.email == "") {
            errorMessage = "Ingresa el email"
            return false
        } else if (stateForm.password == "") {
            errorMessage = "Ingresa el password"
            return false
        } else if (stateForm.confirmPassword == "") {
            errorMessage = "Ingresa el password de confirmacion"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(stateForm.email).matches()) {
            errorMessage = "El email no es valido"
            return false
        } else if (stateForm.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracterres"
            return false
        } else if (stateForm.password != stateForm.confirmPassword) {
            errorMessage = "Las contraseñas no coinciden"
            return false
        }

        return true


    }


}