package io.gdscug.github.g_flix.di

import io.gdscug.github.g_flix.data.GFlixRepository
import RemoteDataSource

object Injection {
    fun provideRepository(): GFlixRepository {
        val remoteDataSource = RemoteDataSource.getInstance()

        return GFlixRepository.getInstance(remoteDataSource)

    }



}