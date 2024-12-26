package com.ionic.foods.domain.usecase

import com.ionic.foods.domain.model.UserList
import com.ionic.foods.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() : UserList {
        return userRepository.getUsers()
    }
}