package com.example.myquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class TelaHungria extends AppCompatActivity {
    private RadioGroup rdGroup;
    private Button btnConfirma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_hungria);
        rdGroup = findViewById(R.id.rdGroupHungria);
        btnConfirma = findViewById(R.id.btnComfirmaHungria);
    }
    public void OnRadioButtonClicked(View view){
        btnConfirma.setEnabled(true);
    }
    public void Confirm(View view){
        int idMarcado = rdGroup.getCheckedRadioButtonId();
        Intent it_telaItalia =new Intent(getApplicationContext(), TelaItalia.class);
        ArrayList<Integer>  arrayPontos = getIntent().getIntegerArrayListExtra("arrayPontos");
        int index = arrayPontos.size()-1;
        int acerto= arrayPontos.get(index);
        if(idMarcado == R.id.rdHungria) {
            acerto++;
        }
        arrayPontos.set(index,acerto);
        it_telaItalia.putIntegerArrayListExtra("arrayPontos", arrayPontos);
        ArrayList<String> arrayName = getIntent().getStringArrayListExtra("arrayNome");
        it_telaItalia.putStringArrayListExtra("arrayNome", arrayName);
        finish();
        startActivity(it_telaItalia);
    }
}