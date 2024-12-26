package com.ionic.foods.data.api

import com.ionic.foods.domain.model.UserList
import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getUsers() : UserList
}