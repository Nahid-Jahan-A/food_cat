package com.ionic.foods.data.api

import com.ionic.foods.domain.model.CategoriesResponse
import retrofit2.http.GET

interface CategoryService {
    @GET("categories.php")
    suspend fun getCategories() : CategoriesResponse
}