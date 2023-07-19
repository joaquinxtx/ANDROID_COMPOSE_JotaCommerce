package com.joaquindev.jotacommerce.data.dataSource.remote

import com.joaquindev.jotacommerce.data.dataSource.remote.service.ProductService
import com.joaquindev.jotacommerce.domain.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class ProductRemoteDataSourceImpl(private val productService: ProductService) :
    ProductRemoteDataSource {
    override suspend fun findAll(): Response<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun findAllByCategory(idCategory: String): Response<List<Product>> =
        productService.findByCategory(idCategory)

    override suspend fun create(product: Product, files: List<File>): Response<Product> {
        val images = arrayOfNulls<MultipartBody.Part>(files.size)
        val contentType = "text/plain"

        files.forEachIndexed { index, file ->
            val connection = withContext(Dispatchers.IO) {
                file.toURI().toURL().openConnection()
            }
            val mimeType = connection.contentType
            val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
            images[index] = MultipartBody.Part.createFormData("files[]", file.name, requestFile)
        }


        val nameData = product.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = product.description.toRequestBody(contentType.toMediaTypeOrNull())
        val idCategoryData = product.idCategory.toRequestBody(contentType.toMediaTypeOrNull())
        val priceData = product.price.toString().toRequestBody(contentType.toMediaTypeOrNull())


        return productService.create(images, nameData, descriptionData, idCategoryData, priceData)
    }

    override suspend fun update(
        id: String,
        product: Product,
        files: List<File>?
    ): Response<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }
}