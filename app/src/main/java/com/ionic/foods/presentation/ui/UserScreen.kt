package com.ionic.foods.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.ionic.foods.presentation.viewmodel.UserViewmodel

@Composable
fun UserScreen(
    modifier: Modifier = Modifier,
    viewmodel: UserViewmodel = hiltViewModel()
) {
    val viewState by viewmodel.userState.collectAsState()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text(
                    text = "Error Occurred: ${viewState.error}",
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            viewState.success.isNotEmpty() -> {
                UserDetailsScreen(viewState.success)
            }

            else -> {
                Text(
                    text = "No Users Available",
                    color = Color.Black,
                )
            }
        }
    }
}