package com.example.tugas5

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_rental.*

class RentalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rental)

        var buttonRent = findViewById<Button>(R.id.buttonRent)
        buttonRent.setOnClickListener(View.OnClickListener {
            val nama = namarent.text.toString()
            val alamat = alamatrent.text.toString()
            val kelamin = radioGroupGenre.checkedRadioButtonId
            val jenis = radioGroupCar.checkedRadioButtonId
            val jemput = jemputRent.text.toString()
            val antar = antarRent.text.toString()
            if (nama.isEmpty()||alamat.isEmpty()||kelamin==null||jenis==null||jemput.isEmpty()||antar.isEmpty()) {
                Toast.makeText(this, "Tolong Lengkapi Data Anda", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }else{
                Toast.makeText(this, "Selamat Menggunakan", Toast.LENGTH_SHORT).show()
            }


        })
    }
}