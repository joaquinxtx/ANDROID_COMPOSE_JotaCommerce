package com.joaquindev.jotacommerce.domain.util

import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {

    fun <T> send(result:Response<T>):Resource<T>{
        return try {
            if (result.isSuccessful) {
                Resource.Success(result.body()!!)

            } else {
                val errorResponse: ErrorResponse? =
                    ConvertErrorBody.convertErrorBody(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconocido")
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error Desconocido en la peticion http")
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure("Verifica tu conexion")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error Desconocido")
        }
    }
}