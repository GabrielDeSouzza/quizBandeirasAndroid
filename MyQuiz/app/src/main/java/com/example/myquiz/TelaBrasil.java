package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class TelaBrasil extends AppCompatActivity {
    private Button btnConfirma;
    private  RadioGroup rbGroupBrasil;
    private  RadioButton rbBrasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_brasil);
        btnConfirma = findViewById(R.id.btnConfirma);
        rbGroupBrasil= findViewById(R.id.rdGroupBrasil);

    }
    public void OnRadioButtonClicked(View view){
        btnConfirma.setEnabled(true);
    }

    public void Confirm(View view){
         int idMarcado = rbGroupBrasil.getCheckedRadioButtonId();
         ArrayList<Integer>  arrayPontos = getIntent().getIntegerArrayListExtra("arrayPontos");
         int index = arrayPontos.size()-1;
         int acerto= arrayPontos.get(index);

         if(idMarcado == R.id.rbBrasil){
             acerto++;
         }
         else {
             acerto=0;
         }
         arrayPontos.set(index,acerto);
         Intent it_telaGuatemala =new Intent(getApplicationContext(), TelaGuatemala.class);
         ArrayList<String> arrayName = getIntent().getStringArrayListExtra("arrayNome");
         it_telaGuatemala.putStringArrayListExtra("arrayNome", arrayName);
         it_telaGuatemala.putIntegerArrayListExtra("arrayPontos", arrayPontos);
         finish();
         startActivity(it_telaGuatemala);
         finish();
    }
}