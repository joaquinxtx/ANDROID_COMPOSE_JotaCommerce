package com.joaquindev.jotacommerce.data.repository.dataSource


import com.joaquindev.jotacommerce.domain.model.User

import retrofit2.Response

interface UsersRemoteDataSource {

    suspend fun update(id:String ,user: User):Response<User>
}