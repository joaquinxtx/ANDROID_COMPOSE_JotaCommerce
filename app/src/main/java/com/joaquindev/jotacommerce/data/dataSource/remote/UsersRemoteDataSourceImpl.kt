package com.joaquindev.jotacommerce.data.dataSource.remote


import com.joaquindev.jotacommerce.data.dataSource.remote.service.UsersService
import com.joaquindev.jotacommerce.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class UsersRemoteDataSourceImpl(private val usersService: UsersService) : UsersRemoteDataSource {
    override suspend fun update(id: String, user: User): Response<User> =
        usersService.update(id, user)

    override suspend fun updateWithImage(id: String, user: User, file: File): Response<User> {
        val connection = withContext(Dispatchers.IO) {
            file.toURI().toURL().openConnection()
        }
        val mimeType = connection.contentType
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = user.name.toRequestBody(contentType.toMediaTypeOrNull())
        val lastnameData = user.lastname.toRequestBody(contentType.toMediaTypeOrNull())
        val phoneData = user.phone.toRequestBody(contentType.toMediaTypeOrNull())

        return usersService.updateWithImage(fileFormData, id, nameData, lastnameData, phoneData)
    }


}