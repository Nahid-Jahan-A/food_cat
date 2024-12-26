package com.ionic.foods.di

import com.ionic.foods.data.api.CategoryService
import com.ionic.foods.data.api.UserService
import com.ionic.foods.data.repository.CategoryRepositoryImpl
import com.ionic.foods.data.repository.UserRepositoryImpl
import com.ionic.foods.domain.repository.CategoryRepository
import com.ionic.foods.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    @UserBaseUrl
    fun provideUserRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @CategoryBaseUrl
    fun providesCategoryBaseUrl() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserService(@UserBaseUrl retrofit: Retrofit) : UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoryService(@CategoryBaseUrl retrofit: Retrofit) : CategoryService {
        return retrofit.create(CategoryService::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun buildUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ) : UserRepository

    @Binds
    abstract fun buildCategoryRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ) : CategoryRepository
}