package com.joaquindev.jotacommerce.domain.useCase.users

import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.repository.UserRepository
import java.io.File

class UpdateUserWithImageUseCase(private val repository:UserRepository) {

    suspend operator fun invoke(id : String , user: User , file:File) = repository.updateWithImage(id, user, file)
}