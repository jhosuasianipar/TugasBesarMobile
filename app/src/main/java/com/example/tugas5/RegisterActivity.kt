package com.example.tugas5

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var buttonReg = findViewById<Button>(R.id.buttonReg)
        buttonReg.setOnClickListener(View.OnClickListener {
            val email = inputEmailReg.text.toString()
            val password = inputPasswordReg.text.toString()
            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "Tolong masukkan email dan password", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val Intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(Intent)
                        finish()
                    } else {

                        Toast.makeText(
                            this,
                            "Register failed.${task.exception}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        })
    }
}