package com.example.minhaprimeiraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // recuperar uma UI componente no arquivo Kotlin
        // recuperar id do componente
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edttextPeso)
        val edtAlt: EditText = findViewById(R.id.edttextAlt)
        val tvResultado: TextView = findViewById(R.id.tvResultado)


        btnCalcular.setOnClickListener {

            val pesoStr = edtPeso.text.toString()
            val alturaStr =  edtAlt.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){
                
            

            val altura: Float =alturaStr.toFloat()
            val edtPeso: Float = pesoStr.toFloat()

            val alturaFinal = altura * altura
            val resultado: Float = edtPeso / alturaFinal

            //tvResultado.text = resultado.toString()

            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", resultado)
                }

            startActivity(intent)
            }else{
                Toast.makeText(this, "Por Favor Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }

        }
        // colocar acao em um botao


    }
}