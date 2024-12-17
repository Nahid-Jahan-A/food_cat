package com.ionic.foods.domain.repository

import com.ionic.foods.domain.model.CategoriesResponse

interface CategoryRepository {
    suspend fun getCategories() : CategoriesResponse
}