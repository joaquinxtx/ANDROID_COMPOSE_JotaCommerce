package com.joaquindev.jotacommerce.domain.useCase.users

import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.repository.UserRepository

class UpdateUserUseCase(private val repository:UserRepository) {

    suspend operator fun invoke(id : String , user: User) = repository.update(id ,user)
}