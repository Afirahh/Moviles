package com.dam.proyectopeliculas.data.ui.popular_movie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dam.proyectopeliculas.R
import kotlinx.android.synthetic.main.transicion.*

class Transicion : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transicion)

        boton100.setOnClickListener() {
        val intento10 = Intent(this, MainActivity::class.java)
        startActivity(intento10)
    }

        boton200.setOnClickListener() {
            val intento20 = Intent(this, MapsActivity::class.java)
            startActivity(intento20)
        }


    }
}