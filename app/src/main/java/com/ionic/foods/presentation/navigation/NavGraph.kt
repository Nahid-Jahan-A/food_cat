package com.ionic.foods.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ionic.foods.presentation.ui.RecipeScreen
import com.ionic.foods.presentation.viewmodel.RecipeViewmodel

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.RecipeScreen.route
    ) {
        // Recipe Screen
        composable(route = Screen.RecipeScreen.route) {
            val recipeViewModel: RecipeViewmodel = hiltViewModel()
            RecipeScreen(
                viewmodel = recipeViewModel,
                onNavigateToDetails = { categoryId ->
//                    navController.navigate(Screen.DetailsScreen.createRoute(categoryId))
                }
            )
        }

        // Details Screen
//        composable(route = Screen.RecipeDetailScreen.route) { backStackEntry ->
//            val categoryId = backStackEntry.arguments?.getString("categoryId") ?: ""
//            RecipeDetailsScreen(categoryId = categoryId)
//        }
    }
}
