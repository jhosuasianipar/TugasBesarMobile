package com.example.tugas5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()
            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "Tolong masukkan email dan password anda", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnCompleteListener{

                    if (!it.isSuccessful){ return@addOnCompleteListener
                        val intent = Intent (this, MainActivity::class.java)
                        startActivity(intent)
                    }
                    else
                        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent (this, RentalActivity::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener{
                    Log.d("Main", "Failed Login: ${it.message}")
                    Toast.makeText(this, "Email/Password Anda Salah", Toast.LENGTH_SHORT).show()
                }

        })

        var buttonReg2 = findViewById<Button>(R.id.buttonReg2)
        buttonReg2.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, RegisterActivity::class.java)
            startActivity(intent)
        })
    }
}