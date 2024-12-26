package com.ionic.foods.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ionic.foods.domain.model.User
import com.ionic.foods.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewmodel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    private val _userState = MutableStateFlow(UserState(loading = true))
    val userState = _userState.asStateFlow()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = getUsersUseCase()
                Log.d("User Viewmodel", "fetchUsers: ${response.users}")
                _userState.value = _userState.value.copy(
                    loading = false,
                    success = response.users,
                    error = null,
                )
            } catch (e: Exception) {
                _userState.value = _userState.value.copy(
                    loading = false,
                    error = "Error fetching users: ${e.message}"
                )
            }
        }
    }
}

data class UserState(
    val loading: Boolean = true,
    val success: List<User> = emptyList(),
    val error: String? = null
)