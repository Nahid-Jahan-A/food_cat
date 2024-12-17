package com.ionic.foods.domain.usecase

import com.ionic.foods.domain.model.CategoriesResponse
import com.ionic.foods.domain.repository.CategoryRepository
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    suspend operator fun invoke() : CategoriesResponse {
        return repository.getCategories()
    }
}