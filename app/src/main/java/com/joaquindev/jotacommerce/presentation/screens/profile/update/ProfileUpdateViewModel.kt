package com.joaquindev.jotacommerce.presentation.screens.profile.update

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase

import com.joaquindev.jotacommerce.domain.useCase.users.UsersUseCase
import com.joaquindev.jotacommerce.presentation.screens.profile.update.mapper.toUser
import com.joaquindev.jotacommerce.presentation.utils.ComposeFileProvider
import com.joaquindev.jotacommerce.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject


@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(

    private val usersUseCase: UsersUseCase,
    private val authUseCase: AuthUseCase,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context
) :
    ViewModel() {


    var state by mutableStateOf(ProfileUpdateState())
        private set

    //Arguments
    val data = savedStateHandle.get<String>("user")
    var user = User.fromJson(data!!)

    //IMAGENES
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    var updateResponse by mutableStateOf<Resource<User>?>(null)

    init {
        state = state.copy(
            name = user.name,
            lastname = user.lastname,

            phone = user.phone,
            image = user.image ?: ""
        )
    }

    fun updateUserSession() = viewModelScope.launch {
        authUseCase.updateSession(state.toUser())
    }

    fun update() = viewModelScope.launch {

        updateResponse = Resource.Loading
        val result = usersUseCase.updateUser(user.id ?: "", state.toUser())
        updateResponse = result
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
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