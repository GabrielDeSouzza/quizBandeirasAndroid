package com.example.myquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TelaBulgaria extends AppCompatActivity {
    private RadioGroup rdGroup;
    private Button btnConfirma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_bulgaria);
        rdGroup = findViewById(R.id.rdGroupBulgaria);
        btnConfirma = findViewById(R.id.btnComfirmaBulgaria);
    }
    public void OnRadioButtonClicked(View view){
        btnConfirma.setEnabled(true);
    }
    public void Confirm(View view){
        int idMarcado = rdGroup.getCheckedRadioButtonId();
        Intent it_telaCorreia =new Intent(getApplicationContext(), TelaCorreiaDoSul.class);
        ArrayList<Integer>  arrayPontos = getIntent().getIntegerArrayListExtra("arrayPontos");
        int index = arrayPontos.size()-1;
        int acerto= arrayPontos.get(index);

        if(idMarcado == R.id.rdBulgaria) {
            acerto++;
        }
        arrayPontos.set(index,acerto);
        it_telaCorreia.putIntegerArrayListExtra("arrayPontos", arrayPontos);
        ArrayList<String> arrayName = getIntent().getStringArrayListExtra("arrayNome");
        it_telaCorreia.putStringArrayListExtra("arrayNome", arrayName);
        finish();
        startActivity(it_telaCorreia);
    }
}