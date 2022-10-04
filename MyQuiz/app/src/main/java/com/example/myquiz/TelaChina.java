package com.example.myquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class TelaChina extends AppCompatActivity {
    private RadioGroup rdGroup;
    private Button btnConfirma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_china);
        rdGroup = findViewById(R.id.rdGroupChina);
        btnConfirma = findViewById(R.id.btnComfirmaChina);

    }
    public void OnRadioButtonClicked(View view){
        btnConfirma.setEnabled(true);
    }
    public void Confirm(View view){
        int idMarcado = rdGroup.getCheckedRadioButtonId();
        Intent intentTelaChina = getIntent();
        Intent it_telaUSA =new Intent(getApplicationContext(), TelaUSA.class);
        ArrayList<Integer>  arrayPontos = getIntent().getIntegerArrayListExtra("arrayPontos");
        int index = arrayPontos.size()-1;
        int acerto= arrayPontos.get(index);
        if(idMarcado == R.id.rdChina) {
            acerto++;
        }
        arrayPontos.set(index,acerto);
        it_telaUSA.putIntegerArrayListExtra("arrayPontos", arrayPontos);
        ArrayList<String> arrayName = getIntent().getStringArrayListExtra("arrayNome");
        it_telaUSA.putStringArrayListExtra("arrayNome", arrayName);
        finish();
        startActivity(it_telaUSA);
    }
}