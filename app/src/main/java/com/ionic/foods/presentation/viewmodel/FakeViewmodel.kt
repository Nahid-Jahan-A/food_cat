package com.ionic.foods.presentation.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ionic.foods.domain.model.Category
import com.ionic.foods.presentation.ui.RecipeScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

//@Composable
//fun RecipeScreenPreview() {
//    RecipeScreen(
//        viewmodel = object : RecipeViewmodel {
//            override val categoryState: StateFlow<RecipeState>
//                get() = MutableStateFlow(
//                    RecipeState(
//                        loading = false,
//                        success = listOf(
//                            Category("1", "Beef", "https://www.themealdb.com/images/category/beef.png"),
//                            Category("2", "Chicken", "https://www.themealdb.com/images/category/chicken.png")
//                        ),
//                        error = null
//                    )
//                ).asStateFlow()
//        }
//    )
//}
