package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ResultadoActivity extends AppCompatActivity {

    TextView textImc;
    TextView textResultadoMensagem;
    ImageView imageResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textImc = findViewById(R.id.text_imc);
        textResultadoMensagem = findViewById(R.id.text_resultato_mensagem);

        imageResultado = findViewById(R.id.image_resultado);

        Intent intent = getIntent();
        double imc = intent.getDoubleExtra("resultado_imc",0);

        String msg;

        if (imc<18) {
            msg = "Cuidado você está abaixo do peso ideal";
            imageResultado.setImageResource(R.drawable.abaixo_peso);
        }
        else if(imc<=25){
            msg = "Parabéns você está dentro do peso normal";
            imageResultado.setImageResource(R.drawable.peso_normal);
        }
        else if(imc<=30){
            msg = "Você está com Sobrepeso";
            imageResultado.setImageResource(R.drawable.sobre_peso);
        }
        else if(imc<=35){
            msg = "Você está com obesidade grau 1";
            imageResultado.setImageResource(R.drawable.obesidade_1);
        }
        else if(imc<=40){
            msg = "Você está com obsidade grau 2";
            imageResultado.setImageResource(R.drawable.obesidade_2);
        }
        else {
            msg = "Você está com obsidade morbida";
            imageResultado.setImageResource(R.drawable.obesidade_3);
        }

        DecimalFormat df = new DecimalFormat("###,##0.00");

        textImc.setText("Seu IMC é " + df.format(imc));
        textResultadoMensagem.setText(msg);

    }

    public void voltar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
