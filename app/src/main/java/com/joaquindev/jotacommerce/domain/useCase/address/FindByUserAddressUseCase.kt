package com.joaquindev.jotacommerce.domain.useCase.address


import com.joaquindev.jotacommerce.domain.repository.AddressRepository

class FindByUserAddressUseCase(private val repository:AddressRepository) {

     operator fun invoke(idUser:String) = repository.findByUser(idUser)


}