package com.example.estacionamientooscar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val advertencia = findViewById<TextView>(R.id.adv)


        val hentrada = findViewById<View>(R.id.txthoraen) as EditText
        val mentrada = findViewById<View>(R.id.txtminutoen) as EditText
        val hsalida = findViewById<View>(R.id.txthorasal) as EditText
        val msalida = findViewById<View>(R.id.txtminutosal) as EditText

        val calcular = findViewById<Button>(R.id.btncalcular)

        calcular.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, nota::class.java)
            if (hentrada.text.toString().toInt() > hsalida.text.toString().toInt()){
                advertencia.text = "hora entrada debe ser mayor a hora salida"
            }
            if (hentrada.text.toString().toInt() <= hsalida.text.toString().toInt()){
                var hen = hentrada.text.toString()
                var men = mentrada.text.toString()
                var hsal = hsalida.text.toString()
                var msal = msalida.text.toString()

                intent.putExtra("hentrada", hen)
                intent.putExtra("mentrada", men)
                intent.putExtra("hsalida", hsal)
                intent.putExtra("msalida", msal)
                startActivity(intent)

            }

        })


    }

}