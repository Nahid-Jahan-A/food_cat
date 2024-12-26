package com.ionic.foods.domain.repository

import com.ionic.foods.domain.model.UserList

interface UserRepository {
    suspend fun getUsers(): UserList
}
