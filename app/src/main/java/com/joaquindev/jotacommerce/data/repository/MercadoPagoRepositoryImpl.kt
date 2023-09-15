package com.joaquindev.jotacommerce.data.repository

import com.joaquindev.jotacommerce.data.dataSource.remote.MercadoPagoRemoteDataSource
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.*
import com.joaquindev.jotacommerce.domain.repository.MercadoPagoRepository
import com.joaquindev.jotacommerce.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MercadoPagoRepositoryImpl(private val remoteDataSource: MercadoPagoRemoteDataSource) : MercadoPagoRepository {
    override fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.getIdentificationType()))
    }

    override fun getInstallments(firstSixDigits: Int, amount: Double): Flow<Resource<Installment>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.getInstallments(firstSixDigits, amount)))
    }
    override suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse> = ResponseToRequest.send(
        remoteDataSource.createCardToken(cardTokenBody)
    )

    override suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse> = ResponseToRequest.send(
        remoteDataSource.createPayment(paymentBody)
    )
}