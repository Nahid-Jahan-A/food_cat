package com.ionic.foods.data.repository

import com.ionic.foods.data.api.CategoryService
import com.ionic.foods.domain.model.CategoriesResponse
import com.ionic.foods.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryService: CategoryService
) : CategoryRepository {
    override suspend fun getCategories(): CategoriesResponse {
        return categoryService.getCategories()
    }
}