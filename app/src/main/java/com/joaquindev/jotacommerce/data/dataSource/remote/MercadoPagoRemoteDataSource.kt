package com.joaquindev.jotacommerce.data.dataSource.remote

import com.joaquindev.jotacommerce.domain.model.IdentificationType
import com.joaquindev.jotacommerce.domain.model.Installment
import retrofit2.Response


interface MercadoPagoRemoteDataSource {


    suspend fun getIdentificationType(): Response<List<IdentificationType>>


    suspend fun getInstallments(
         firstSixDigits: Int,
         amount: Double,
    ): Response<Installment>
}