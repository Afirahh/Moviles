package com.dam.proyectopeliculas.data.API

import com.dam.proyectopeliculas.data.vo.MovieDetails
import com.dam.proyectopeliculas.data.vo.MovieResponse
import com.dam.proyectopeliculas.single_movie_details.SingleMovie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {
    // https://api.themoviedb.org/3/movie/popular?api_key=6e63c2317fbe963d76c3bdc2b785f6d1&page=1
    // https://api.themoviedb.org/3/movie/299534?api_key=6e63c2317fbe963d76c3bdc2b785f6d1
    // https://api.themoviedb.org/3/


    //Un valor entre {} es una variable, cambia automaticamente con cada llamada
    @GET("movie/{movie_id}")
    //Este metodo llama a la API y saca la id id:Int y la vuelca en la variable, con Single recibimos un solo valor
    fun getMovieDetails(@Path( "movie_id")id:Int): Single<MovieDetails>


    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>
}