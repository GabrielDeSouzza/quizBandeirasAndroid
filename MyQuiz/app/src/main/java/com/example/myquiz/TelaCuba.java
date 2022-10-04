package com.example.myquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class TelaCuba extends AppCompatActivity {
    private RadioGroup rdGroup;
    private Button btnConfirma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cuba);
        rdGroup = findViewById(R.id.rdGroupCuba);
        btnConfirma = findViewById(R.id.btnComfirmaCuba);
    }
    public void OnRadioButtonClicked(View view){
        btnConfirma.setEnabled(true);
    }
    public void Confirm(View view){
        int idMarcado = rdGroup.getCheckedRadioButtonId();
        Intent it_telaBulgaria =new Intent(getApplicationContext(), TelaBulgaria.class);
        ArrayList<Integer>  arrayPontos = getIntent().getIntegerArrayListExtra("arrayPontos");
        int index = arrayPontos.size()-1;
        int acerto= arrayPontos.get(index);
        if(idMarcado == R.id.rdCuba) {
            acerto++;
        }
        arrayPontos.set(index,acerto);
        it_telaBulgaria.putIntegerArrayListExtra("arrayPontos", arrayPontos);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        ArrayList<String> arrayName = getIntent().getStringArrayListExtra("arrayNome");
        it_telaBulgaria.putStringArrayListExtra("arrayNome", arrayName);
        startActivity(it_telaBulgaria);
        finish();
    }
}