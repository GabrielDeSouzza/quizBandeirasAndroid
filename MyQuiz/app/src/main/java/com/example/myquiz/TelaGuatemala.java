package com.example.myquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class TelaGuatemala extends AppCompatActivity {
    private Button btnConfirma;
    private RadioGroup rdGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_guatemala);
        btnConfirma = findViewById(R.id.btnComfirmaGuatemala);
        rdGroup = findViewById(R.id.rdGroupGuatemala);
    }
    public void OnRadioButtonClicked(View view){
        btnConfirma.setEnabled(true);
    }
 public void Confirm(View view){
        int idMarcado = rdGroup.getCheckedRadioButtonId();
        Intent it_telaChina =new Intent(getApplicationContext(), TelaChina.class);
        ArrayList<Integer>  arrayPontos = getIntent().getIntegerArrayListExtra("arrayPontos");
        int index = arrayPontos.size()-1;
        int acerto= arrayPontos.get(index);
        if(idMarcado == R.id.rbGuatemala) {
            acerto++;
        }
        arrayPontos.set(index,acerto);arrayPontos.set(index,acerto);
        it_telaChina.putIntegerArrayListExtra("arrayPontos", arrayPontos);
        ArrayList<String> arrayName = getIntent().getStringArrayListExtra("arrayNome");
        it_telaChina.putStringArrayListExtra("arrayNome", arrayName);
        finish();
        startActivity(it_telaChina);
    }
}