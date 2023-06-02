package com.joaquindev.jotacommerce.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor():ViewModel() {

    var stateForm by mutableStateOf(RegisterState())
    private set


    var errorMessage by mutableStateOf("")
        private set

    fun onNameInput(name:String){
        stateForm = stateForm.copy(name = name)
    }
    fun onLastNameInput(lastName:String){
        stateForm = stateForm.copy(lastname = lastName)
    }
    fun onEmailInput(email:String){
        stateForm = stateForm.copy(email = email)
    }
    fun onPhoneInput(phone:String){
        stateForm = stateForm.copy(phone = phone)
    }
    fun onPasswordInput(password:String){
        stateForm = stateForm.copy(password= password)
    }
    fun onConfirmPasswordInput(confirmPassword:String){
        stateForm = stateForm.copy(confirmPassword = confirmPassword)
    }



    fun validateForm() =viewModelScope.launch {
        if (stateForm.name == ""){
            errorMessage="Ingresa el nombre"
        }
        else if (stateForm.lastname == ""){
            errorMessage="Ingresa el apellido"
        }
        else if (stateForm.phone == ""){
            errorMessage="Ingresa el telefono"
        }
        else if (stateForm.email == ""){
            errorMessage="Ingresa el email"
        }
        else if (stateForm.password == ""){
            errorMessage="Ingresa el password"
        }
        else if (stateForm.confirmPassword == ""){
            errorMessage="Ingresa el password de confirmacion"
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(stateForm.email).matches()) {
            errorMessage = "El email no es valido"
        }
        else if (stateForm.password.length < 6){
            errorMessage = "La contraseña debe tener al menos 6 caracterres"
        }
        else if (stateForm.password != stateForm.confirmPassword){
            errorMessage = "Las contraseñas no coinciden"
        }

        delay(3000)
        errorMessage=""


    }


}