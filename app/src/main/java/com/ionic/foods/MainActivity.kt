package com.ionic.foods

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ionic.foods.presentation.ui.RecipeScreen
import com.ionic.foods.presentation.viewmodel.RecipeViewmodel
import com.ionic.foods.ui.theme.FoodsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val recipeViewmodel: RecipeViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecipeScreen(modifier = Modifier.padding(innerPadding), recipeViewmodel)
                }
            }
        }
    }
}