package com.dam.proyectopeliculas.data.ui.popular_movie

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dam.proyectopeliculas.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registro.*

class Registro : AppCompatActivity() {


     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        var mAuth = FirebaseAuth.getInstance()

        //comprobacion de que no hay ningun usuario en uso
        if(mAuth.currentUser!=null){
            val intento2 = Intent(this, MainLogin::class.java)
            startActivity(intento2)
            finish()
        }

        boton11.setOnClickListener(){



            val valor11 = texto11.text.toString()
            val valor22 = texto22.text.toString()



            if(valor11.isEmpty()){
                texto22.setError("El campo email es obligatorio")
                return@setOnClickListener
            }

            if(valor22.isEmpty()){
                texto22.setError("El campo contraseña es obligatorio")
                return@setOnClickListener
            }
            if(valor22.length < 4){
                texto22.setError("La contraseña debe tener mas de 4 caracteres")
                return@setOnClickListener
            }



            //registramos el usuario en la base de datos
            mAuth.createUserWithEmailAndPassword(valor11,valor22)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Se la logeado bien
                        Toast.makeText(this,"Usuario creado",Toast.LENGTH_LONG).show()
                        val intento1 = Intent(this, MainLogin::class.java)
                        startActivity(intento1)

                    } else {
                        // No se ha logeado bien
                        Toast.makeText(this,"El usuario no se ha creado",Toast.LENGTH_LONG).show()




                    }


                }
        }
        tv22.setOnClickListener() {
            val intento5 = Intent(this, MainLogin::class.java)
            startActivity(intento5)
        }
    }
}