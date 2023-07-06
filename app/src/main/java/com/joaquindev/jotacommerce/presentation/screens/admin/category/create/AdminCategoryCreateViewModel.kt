package com.joaquindev.jotacommerce.presentation.screens.admin.category.create

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.domain.useCase.catgeories.CategoriesUseCase
import com.joaquindev.jotacommerce.presentation.screens.admin.category.create.mapper.toCategory
import com.joaquindev.jotacommerce.presentation.utils.ComposeFileProvider
import com.joaquindev.jotacommerce.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext

import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject


@HiltViewModel
class AdminCategoryCreateViewModel @Inject constructor(
    private val categoryUseCase: CategoriesUseCase,
    @ApplicationContext val context: Context
) : ViewModel() {

    var state by mutableStateOf(AdminCategoryCreateState())
        private set

    //images
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    var categoryResponse by mutableStateOf<Resource<Category>?>(null)

    fun createCategory() = viewModelScope.launch {
        if (file != null) {
            categoryResponse = Resource.Loading
            val result = categoryUseCase.createCategory(state.toCategory(), file!!)
            categoryResponse = result

        }
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*") // URI
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onDescriptionInput(description: String) {
        state = state.copy(description = description)
    }

    fun clearForm() {
        state = state.copy(name = "", description = "", image = "")
        categoryResponse = null
    }
}