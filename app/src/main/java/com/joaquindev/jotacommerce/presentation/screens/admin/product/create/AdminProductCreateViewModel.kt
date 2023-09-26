package com.joaquindev.jotacommerce.presentation.screens.admin.product.create

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.domain.useCase.product.ProductUseCase
import com.joaquindev.jotacommerce.presentation.screens.admin.product.create.mapper.toProduct
import com.joaquindev.jotacommerce.presentation.utils.ComposeFileProvider
import com.joaquindev.jotacommerce.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminProductCreateViewModel @Inject constructor(
    private val productUseCase: ProductUseCase,
    @ApplicationContext val context: Context,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(AdminProductCreateState())
        private set

    var data = savedStateHandle.get<String>("category")
    var category = Category.fromJson(data!!)

    //images
    var file1: File? = null
    var file2: File? = null
    var files:List<File> = listOf()
    val resultingActivityHandler = ResultingActivityHandler()

    var productResponse by mutableStateOf<Resource<Product>?>(null)
        private set

    init {
        state = state.copy(idCategory = category.id ?: "")
    }

    fun createProduct() = viewModelScope.launch {

        if(file1 != null && file2 != null){
            files = listOf(file1!!,file2!!)
            productResponse = Resource.Loading
            val result = productUseCase.createProduct(state.toProduct(),files)
            productResponse = result
        }

    }


    fun pickImage(imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*") // URI
        if (result != null) {
            if (imageNumber == 1) {
                file1 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image1 = result.toString())

            } else if (imageNumber == 2) {
                file2 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image2 = result.toString())
            }
        }
    }

    fun takePhoto(imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            if (imageNumber == 1) {
                state = state.copy(image1 = ComposeFileProvider.getPathFromBitmap(context, result))
                file1 = File(state.image1)

            } else if (imageNumber == 2) {
                state = state.copy(image2 = ComposeFileProvider.getPathFromBitmap(context, result))
                file2 = File(state.image2)
            }

        }
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onDescriptionInput(description: String) {
        state = state.copy(description = description)
    }

    fun onPriceInput(price: String) {
        try {
            val parsedPrice = price.toDouble()
            state = state.copy(price = parsedPrice)
        } catch (_: NumberFormatException) {

        }
    }

    fun clearForm() {
        state = state.copy(name = "", description = "", image1 = "", image2 = "", price = 0.0)
        productResponse = null
    }
}