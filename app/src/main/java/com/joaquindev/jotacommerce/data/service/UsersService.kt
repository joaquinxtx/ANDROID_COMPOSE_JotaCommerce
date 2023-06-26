package com.joaquindev.jotacommerce.data.service


import com.joaquindev.jotacommerce.domain.model.User

import retrofit2.Response
import retrofit2.http.Body


import retrofit2.http.PUT
import retrofit2.http.Path

interface UsersService {

    @PUT("users/{id}")
    suspend fun update(
        @Path("id") id:String,
        @Body() user: User,
    ):Response<User>


}