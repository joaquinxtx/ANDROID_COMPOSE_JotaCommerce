package com.joaquindev.jotacommerce.presentation.screens.profile.update

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(private val authUseCase: AuthUseCase):ViewModel() {


    var user by mutableStateOf<User?>(null)
    private set


}