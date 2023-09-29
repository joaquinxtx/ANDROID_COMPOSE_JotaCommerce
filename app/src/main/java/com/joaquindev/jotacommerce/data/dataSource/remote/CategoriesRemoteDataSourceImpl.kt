package com.joaquindev.jotacommerce.data.dataSource.remote


import com.joaquindev.jotacommerce.data.dataSource.remote.service.CategoryService
import com.joaquindev.jotacommerce.domain.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class CategoriesRemoteDataSourceImpl(private val categoryService: CategoryService) :
    CategoriesRemoteDataSource {
    override suspend fun create(category: Category, file: File): Response<Category> {
        val connection = withContext(Dispatchers.IO) {
            file.toURI().toURL().openConnection()
        }
        val mimeType = connection.contentType
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = category.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = category.description.toRequestBody(contentType.toMediaTypeOrNull())


        return categoryService.create(fileFormData, nameData, descriptionData)
    }

    override suspend fun getCategories(): Response<List<Category>> = categoryService.getCategories()

    override suspend fun update(id: String, category: Category): Response<Category> =
        categoryService.update(id, category)

    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Response<Category> {
        val connection = withContext(Dispatchers.IO) {
            file.toURI().toURL().openConnection()
        }
        val mimeType = connection.contentType
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = category.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = category.description.toRequestBody(contentType.toMediaTypeOrNull())


        return categoryService.updateWithImage(fileFormData, id, nameData, descriptionData)
    }

    override suspend fun delete(id: String): Response<Unit> = categoryService.delete(id)
}