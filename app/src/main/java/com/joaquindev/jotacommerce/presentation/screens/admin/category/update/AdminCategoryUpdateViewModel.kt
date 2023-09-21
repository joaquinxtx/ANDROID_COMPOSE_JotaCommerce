package com.joaquindev.jotacommerce.presentation.screens.admin.category.update

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.domain.useCase.catgeories.CategoriesUseCase
import com.joaquindev.jotacommerce.presentation.screens.admin.category.update.mapper.toCategory
import com.joaquindev.jotacommerce.presentation.utils.ComposeFileProvider
import com.joaquindev.jotacommerce.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext

import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject


@HiltViewModel
class AdminCategoryUpdateViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val categoryUseCase: CategoriesUseCase,
    @ApplicationContext val context:Context
) : ViewModel() {

    var state by mutableStateOf(AdminCategoryUpdateState())
    private set

    //images
    var file: File? =null
    val resultingActivityHandler = ResultingActivityHandler()

    val data = savedStateHandle.get<String>("category")

    val category = Category.fromJson(data!!)

    init {
        state=state.copy(
            name = category.name,
            image = category.image!!,
            description = category.description
        )
    }

    fun onUpdate(){
        if (file!=null){
            updateCategoryWidthImage()
        }else{
            updateCategory()
        }
    }

    var categoryResponse by mutableStateOf<Resource<Category>?>(null)

    private fun updateCategory() = viewModelScope.launch {

        categoryResponse = Resource.Loading
        val result = categoryUseCase.updateCategory( id = category.id ?: "",state.toCategory())
            categoryResponse =result
    }

    private fun updateCategoryWidthImage() = viewModelScope.launch {

        categoryResponse = Resource.Loading
        val result = categoryUseCase.updateCategoryWidthImage( id = category.id ?: "",state.toCategory(), file!!)
            categoryResponse =result


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


}