package com.example.estacionamientooscar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class nota : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)
        val entrada = findViewById<TextView>(R.id.horaen)
        val salida = findViewById<TextView>(R.id.horasal)

        val total = findViewById<TextView>(R.id.horastotal)
        val precio = findViewById<TextView>(R.id.preciototal)

        val hentra = intent.getStringExtra("hentrada")
        var mentra = intent.getStringExtra("mentrada")
        var hsali = intent.getStringExtra("hsalida")
        var msali = intent.getStringExtra("msalida")

        entrada.text = hentra+" : "+mentra
        salida.text = hsali+" : "+msali

        val tiempoentrada = mentra.toString().toInt()+(hentra.toString().toInt()*60)
        val tiemposalida = msali.toString().toInt()+(hsali.toString().toInt()*60)

        val tparcial = (tiemposalida-tiempoentrada)/60
        var residuo:Double = tparcial.toDouble()%1
        total.text = "TIEMPO TOTAL: "+tparcial+" horas"
        val preciototal = (tparcial+1)*15
        precio.text = "PRECIO: (se cobra la fraccion como una hora mas) $"+preciototal

    }

}