package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    TextInputLayout l1,l2;

    TextInputEditText inputEditTextPeso;
    TextInputEditText inputEditTextAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l1 = findViewById(R.id.textInputLayout);
        l2 = findViewById(R.id.textInputLayout3);

        inputEditTextPeso = findViewById(R.id.text_peso);
        inputEditTextAltura = findViewById(R.id.text_altura);

        inputEditTextPeso.requestFocus();

    }

    public void cacularIMC(View view){

        if(!validaCampos()) return;

        double peso = Double.parseDouble(inputEditTextPeso.getText().toString());
        double altura = Double.parseDouble(inputEditTextAltura.getText().toString());

        if(!validaValores(peso,altura)) return;

        double imc = peso/(altura*altura);

        Intent intent = new Intent(this, ResultadoActivity.class);

        intent.putExtra("resultado_imc",imc);

        startActivity(intent);
    }

    private boolean validaValores(double peso, double altura) {

        if(peso <= 0 || altura <= 0){
            mensagem("Você não pode informar valores menores ou iguais a zero");
            return false;
        }

        if (peso > 600){
            mensagem("Você não pode informar um peso maior que 600kg");
            return false;
        }

        if (altura > 3){
            mensagem("Você não pode informar uma altura maior que 3m");
            return false;
        }

        return true;
    }

    private void mensagem(String mensagem){
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.makeText(this, mensagem,Toast.LENGTH_LONG).show();
    }

    public boolean validaCampos(){
        if(inputEditTextPeso.getText().toString().isEmpty()){
            l1.setError("Campo obrigatório");
            return false;
        }else l1.setErrorEnabled(false);
        if(inputEditTextAltura.getText().toString().isEmpty()){
            l2.setError("Campo obrigatório");
            return false;
        }else l2.setErrorEnabled(false);

        return true;
    }
}
