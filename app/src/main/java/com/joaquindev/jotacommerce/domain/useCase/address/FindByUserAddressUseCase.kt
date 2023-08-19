package com.joaquindev.jotacommerce.domain.useCase.address

import com.joaquindev.jotacommerce.domain.model.Address
import com.joaquindev.jotacommerce.domain.repository.AddressRepository

class FindByUserAddressUseCase(private val repository:AddressRepository) {

    suspend operator fun invoke(idUser:String) = repository.findByUser(idUser)


}