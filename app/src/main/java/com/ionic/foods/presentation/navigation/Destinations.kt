package com.ionic.foods.presentation.navigation

sealed class Screen(val route: String) {
    data object RecipeScreen : Screen("recipe_screen")
    data object RecipeDetailScreen : Screen("recipe_detail_screen/{categoryId}") {
        fun createRoute(categoryId: String) = "recipe_detail_screen/$categoryId"
    }
}