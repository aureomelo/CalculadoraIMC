package com.example.minhaprimeiraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val tvResult = findViewById<TextView>(R.id.textView_result)
        val tvClassificacao = findViewById<TextView>(R.id.textView_Classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT",0.01f)

        tvResult.text = result.toString()


        val classificacao =  if(result < 18.5f){
            "ABAIXO DO PESO"
        }else if(result in 18.5f ..25f){
            "PESO NORMAL"

        }else if (result >= 25f && result < 30f) {
            "SOBREPESO I "
        }else if (result >= 30f && result < 40f) {
            "OBESIDADE II "
        }else{

            "OBESIDADE III"
        }
        tvClassificacao.text = getString(R.string.message_classificacao,classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        finish()
        return super.onOptionsItemSelected(item)
    }
}