package com.dam.proyectopeliculas.data.repository

import androidx.lifecycle.MutableLiveData
import com.dam.proyectopeliculas.data.API.TheMovieDBInterface
import com.dam.proyectopeliculas.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable
import androidx.paging.DataSource

class MovieDataSourceFactory (private val apiService : TheMovieDBInterface, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>(){

    val moviesLiveDataSource = MutableLiveData<MovieDataSource>()
    override fun create(): DataSource<Int , Movie>{
        val movieDataSource = MovieDataSource(apiService, compositeDisposable)
        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }

}