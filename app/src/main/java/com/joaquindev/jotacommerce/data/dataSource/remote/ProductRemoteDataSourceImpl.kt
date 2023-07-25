package com.joaquindev.jotacommerce.data.dataSource.remote

import com.joaquindev.jotacommerce.data.dataSource.remote.service.ProductService
import com.joaquindev.jotacommerce.domain.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class ProductRemoteDataSourceImpl(private val productService: ProductService) :
    ProductRemoteDataSource {
    override suspend fun findAll(): Response<List<Product>> = productService.findAll()

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

    override suspend fun update(id: String, product: Product): Response<Product> =
        productService.update(id, product)

    override suspend fun updateWithImage(
        id: String,
        product: Product,
        files: List<File>?
    ): Response<Product> {
        val images = arrayOfNulls<MultipartBody.Part>(files?.size ?: 0)
        val contentType = "text/plain"
        val imagesToUpdate = arrayOfNulls<RequestBody>(product.imageToUpdate?.size ?: 0)

        files?.forEachIndexed { index, file ->
            val connection = withContext(Dispatchers.IO) {
                file.toURI().toURL().openConnection()
            }
            val mimeType = connection.contentType
            val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
            images[index] = MultipartBody.Part.createFormData("files[]", file.name, requestFile)
    }
        product.imageToUpdate?.forEachIndexed{ index , position ->
            imagesToUpdate[index] = position.toString().toRequestBody(contentType.toMediaTypeOrNull())
        }
        val nameData = product.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = product.description.toRequestBody(contentType.toMediaTypeOrNull())
        val idCategoryData = product.idCategory.toRequestBody(contentType.toMediaTypeOrNull())
        val priceData = product.price.toString().toRequestBody(contentType.toMediaTypeOrNull())


        return productService.updateWithImage(images,id, nameData, descriptionData, idCategoryData, priceData , imagesToUpdate)
    }

    override suspend fun delete(id: String): Response<Unit>  = productService.delete(id)
}