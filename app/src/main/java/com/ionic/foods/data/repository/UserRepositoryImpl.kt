package com.ionic.foods.data.repository

import android.util.Log
import com.ionic.foods.data.api.UserService
import com.ionic.foods.domain.model.UserList
import com.ionic.foods.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
) : UserRepository {
    override suspend fun getUsers(): UserList {
        val response = userService.getUsers()
        Log.d("User Response", "getUsers: ${response.users}")
        return response
    }
}