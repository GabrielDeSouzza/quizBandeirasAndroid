package com.example.myquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class TelaCanada extends AppCompatActivity {
    private RadioGroup rdGroup;
    private Button btnConfirma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_canada);
        rdGroup = findViewById(R.id.rdGroupCanada);
        btnConfirma = findViewById(R.id.btnComfirmaCanada);
    }
    public void OnRadioButtonClicked(View view){
        btnConfirma.setEnabled(true);
    }
    public void Confirm(View view){
        int idMarcado = rdGroup.getCheckedRadioButtonId();
        Intent it_telaCuba =new Intent(getApplicationContext(), TelaCuba.class);
        ArrayList<Integer>  arrayPontos = getIntent().getIntegerArrayListExtra("arrayPontos");
        int index = arrayPontos.size()-1;
        int acerto= arrayPontos.get(index);

        if(idMarcado == R.id.rdCanada) {
            acerto++;
        }
        arrayPontos.set(index,acerto);
        it_telaCuba.putIntegerArrayListExtra("arrayPontos", arrayPontos);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        ArrayList<String> arrayName = getIntent().getStringArrayListExtra("arrayNome");
        it_telaCuba.putStringArrayListExtra("arrayNome", arrayName);
        startActivity(it_telaCuba);
        finish();
    }
}