package com.joaquindev.jotacommerce.domain.useCase.auth

import com.joaquindev.jotacommerce.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email:String,password:String)= repository.login(email, password)

}