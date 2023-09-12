package com.joaquindev.jotacommerce.data.dataSource.remote

import com.joaquindev.jotacommerce.data.dataSource.remote.service.MercadoPagoService
import com.joaquindev.jotacommerce.domain.model.*
import retrofit2.Response

class MercadoPagoRemoteDataSourceImpl(private val mercadoPagoService: MercadoPagoService): MercadoPagoRemoteDataSource {
    override suspend fun getIdentificationType():Response<List<IdentificationType>>  = mercadoPagoService.getIdentificationType()

    override suspend fun getInstallments(
        firstSixDigits: Int,
        amount: Double
    ): Response<Installment> = mercadoPagoService.getInstallments(firstSixDigits, amount)

    override suspend fun createCardToken(cardTokenBody: CardTokenBody): Response<CardTokenResponse> = mercadoPagoService.createCardToken(cardTokenBody)
    override suspend fun createPayment(paymentBody: PaymentBody): Response<PaymentResponse> = mercadoPagoService.createPayment(paymentBody)
}

