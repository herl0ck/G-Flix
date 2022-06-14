package io.gdscug.github.g_flix.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.gdscug.github.g_flix.data.GFlixRepository
import io.gdscug.github.g_flix.data.MovieEntity
import io.gdscug.github.g_flix.utils.dummy.MovieDummy

class HomeViewModel(private val gFlixRepository: GFlixRepository) : ViewModel() {
    fun getMovies(): LiveData<List<MovieEntity>> = gFlixRepository.getAllMovies()

    fun getMoviesRecomendation(): LiveData<List<MovieEntity>> =
        gFlixRepository.getRecomendation(random().toString())

    fun random(): Int {
        return (1..600).random()
    }
}