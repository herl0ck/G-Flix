package io.gdscug.github.g_flix.data

import androidx.lifecycle.LiveData


interface GFlixDataSource {
    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getRecomendation(id: String): LiveData<List<MovieEntity>>
}