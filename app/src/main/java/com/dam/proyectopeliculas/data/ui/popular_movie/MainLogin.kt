package com.dam.proyectopeliculas.data.ui.popular_movie


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dam.proyectopeliculas.R

import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.mainlogin.*

class MainLogin : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainlogin)
        var mAuth = FirebaseAuth.getInstance()

        boton1.setOnClickListener() {
            val valor2 = texto2.text.toString()
            val valor3 = texto3.text.toString()
            if (valor2.isEmpty()) {
                texto2.setError("El campo email es obligatorio")
                return@setOnClickListener
            }

            if (valor3.isEmpty()) {
                texto3.setError("El campo contraseña es obligatorio")
                return@setOnClickListener
            }
            if (valor3.length < 4) {
                texto3.setError("La contraseña debe tener mas de 4 caracteres")
                return@setOnClickListener
            }


            //Autenticamos el usuario
            mAuth.signInWithEmailAndPassword(valor2, valor3).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Logeado con exito", Toast.LENGTH_LONG).show()
                    val intento1 = Intent(this, Transicion::class.java)
                    startActivity(intento1)

                } else {
                    // No se ha logeado bien
                    Toast.makeText(this, "Ese usuario no existe", Toast.LENGTH_LONG).show()
                }

            }
        }
        tv2.setOnClickListener(){
            val intento4 = Intent(this, Registro::class.java)
            startActivity(intento4)
        }
    }
}