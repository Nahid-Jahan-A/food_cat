package com.ionic.foods.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ionic.foods.domain.model.Category
import com.ionic.foods.domain.usecase.GetCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewmodel @Inject constructor(
    private val getCategoryUseCase: GetCategoryUseCase
) : ViewModel() {
    private val _categoryState = MutableStateFlow(RecipeState(loading = true))
    val categoryState = _categoryState.asStateFlow()

    init {
        fetchCategories()
    }

     private fun fetchCategories() {
         viewModelScope.launch {
             try {
                 val response = getCategoryUseCase()
                 Log.d("RES VM", "fetchCategories: ${response.categories}")
                 _categoryState.value = _categoryState.value.copy(
                     loading = false,
                     success = response.categories,
                     error = null
                 )
             } catch (e: Exception) {
                 Log.e("Error", "Error fetchCategories: ${e.message}", )
                 _categoryState.value = _categoryState.value.copy(
                     loading = false,
                     error = "Error fetching categories: ${e.message}"
                 )
             }
         }
     }
}

data class RecipeState(
    val loading: Boolean = true,
    val success: List<Category> = emptyList(),
    val error: String? = null
)