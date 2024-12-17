package com.ionic.foods.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ionic.foods.domain.model.Category
import com.ionic.foods.domain.usecase.GetCategoryUseCase
import com.ionic.foods.domain.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewmodel @Inject constructor(
    private val getCategoryUseCase: GetCategoryUseCase
) : ViewModel() {
    private val _categoryState = MutableStateFlow(RecipeState(loading = true))
    val categories : StateFlow<RecipeState> get() = _categoryState
    val categoryState = _categoryState.asStateFlow()

    init {
        fetchCategories()
    }

     private fun fetchCategories() {
         viewModelScope.launch {
             try {
                 val response = getCategoryUseCase()
                 _categoryState.value = _categoryState.value.copy(
                     loading = false,
                     success = response.categories,
                     error = null
                 )
             } catch (e: Exception) {
                 _categoryState.value = _categoryState.value.copy(
                     loading = false,
                     error = "Error fetching categories: ${e.message}"
                 )
             }
         }
//         viewModelScope.launch {
//            try {
//                _categoryState.value = _categoryState.value.copy(loading = true)
//                val response = getCategoryUseCase.invoke()
//                Log.d("TAG", "fetchCategories: ${response.subList(0, response.size)}")
//                _categoryState.value = _categoryState.value.copy(
//                    loading = false,
//                    success = response,
//                    error = null
//                )
//            } catch (e: Exception) {
//                _categoryState.value = _categoryState.value.copy(
//                    loading = false,
//                    error = "Error fetching categories: ${e.message}"
//                )
//            }
//        }
//
//         }
     }
}

data class RecipeState(
    val loading: Boolean = true,
    val success: List<Category> = emptyList(),
    val error: String? = null
)