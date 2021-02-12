package com.dam.proyectopeliculas.single_movie_details

import androidx.lifecycle.LiveData
import com.dam.proyectopeliculas.data.API.TheMovieDBInterface
import com.dam.proyectopeliculas.data.repository.MovieDetailsNetworkDataSource
import com.dam.proyectopeliculas.data.repository.NetworkState
import com.dam.proyectopeliculas.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface){
    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}