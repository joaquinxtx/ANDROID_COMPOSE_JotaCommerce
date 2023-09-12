package com.joaquindev.jotacommerce.data.dataSource.remote

import com.joaquindev.jotacommerce.domain.model.*
import retrofit2.Response


interface MercadoPagoRemoteDataSource {


    suspend fun getIdentificationType(): Response<List<IdentificationType>>


    suspend fun getInstallments(
         firstSixDigits: Int,
         amount: Double,
    ): Response<Installment>

    suspend fun createCardToken(cardTokenBody: CardTokenBody): Response<CardTokenResponse>
    suspend fun createPayment(paymentBody: PaymentBody): Response<PaymentResponse>
}