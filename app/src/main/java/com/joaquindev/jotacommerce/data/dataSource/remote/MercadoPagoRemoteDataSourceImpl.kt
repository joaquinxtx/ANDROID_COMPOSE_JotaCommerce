package com.joaquindev.jotacommerce.data.dataSource.remote

import com.joaquindev.jotacommerce.data.dataSource.remote.service.MercadoPagoService
import com.joaquindev.jotacommerce.domain.model.IdentificationType
import com.joaquindev.jotacommerce.domain.model.Installment
import retrofit2.Response

class MercadoPagoRemoteDataSourceImpl(private val mercadoPagoService: MercadoPagoService) :
    MercadoPagoRemoteDataSource {
    override suspend fun getIdentificationType(): Response<List<IdentificationType>> =
        mercadoPagoService.getIdentificationType()

    override suspend fun getInstallments(
        firstSixDigits: Int,
        amount: Double
    ): Response<Installment> = mercadoPagoService.getInstallments(firstSixDigits,amount)
}