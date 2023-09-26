package com.joaquindev.jotacommerce.presentation.screens.admin.category.list

import android.util.Log
import androidx.compose.runtime.*

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.domain.model.User
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase
import com.joaquindev.jotacommerce.domain.useCase.catgeories.CategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminCategoryListViewModel @Inject constructor(private val categoriesUseCase: CategoriesUseCase,private val authUseCase: AuthUseCase) :
    ViewModel() {
    var user by mutableStateOf<User?>(null)
        private set

    var categoriesResponse by mutableStateOf<Resource<List<Category>>?>(value = null)
        private set

    var deleteCategoryResponse by mutableStateOf<Resource<Unit>?>(value = null)
        private set

    init {
        getCategories()
        getSessionData()
    }
    fun getSessionData()= viewModelScope.launch {
        authUseCase.getSessionData().collect{ data ->
            user = data.user
        }
    }


    fun getCategories() = viewModelScope.launch {
        categoriesResponse = Resource.Loading
        categoriesUseCase.getCategories().collect {
            Log.d("getCategories", "data : $it")
            categoriesResponse = it
        }
    }

    fun deleteCategory(id: String) = viewModelScope.launch {
        deleteCategoryResponse = Resource.Loading
        val result = categoriesUseCase.deleteCategory(id)
        deleteCategoryResponse = result
    }

}