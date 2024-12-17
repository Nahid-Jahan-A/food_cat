package com.ionic.foods.di

import com.ionic.foods.data.api.CategoryService
import com.ionic.foods.data.repository.CategoryRepositoryImpl
import com.ionic.foods.domain.repository.CategoryRepository
import com.ionic.foods.domain.usecase.GetCategoryUseCase
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
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCategoryService(retrofit: Retrofit) : CategoryService {
        return retrofit.create(CategoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideGetCategoryUseCase(categoryRepository: CategoryRepository) : GetCategoryUseCase {
        return GetCategoryUseCase(categoryRepository)
    }

}


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun buildCategoryRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ) : CategoryRepository
}