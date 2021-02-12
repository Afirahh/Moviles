package com.dam.proyectopeliculas.data.ui.popular_movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dam.proyectopeliculas.R
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.OnMapReadyCallback
import com.google.android.libraries.maps.SupportMapFragment
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions


class Mapita : AppCompatActivity() {


    lateinit var mapFragment : SupportMapFragment
    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mapita)

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it

            val location1 = LatLng(13.03,77.60)
            googleMap.addMarker(MarkerOptions().position(location1).title("My Location"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,5f))

            val location2 = LatLng(9.89,78.11)
            googleMap.addMarker(MarkerOptions().position(location2).title("Madurai"))


            val location3 = LatLng(13.00,77.00)
            googleMap.addMarker(MarkerOptions().position(location3).title("Bangalore"))

        })
    }
}
