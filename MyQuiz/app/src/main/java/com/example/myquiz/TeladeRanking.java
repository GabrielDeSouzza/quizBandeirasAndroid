package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TeladeRanking extends AppCompatActivity {
    private ListView lvNomes, lvPontos;
    private Button btnNovamente, btnTelaIncial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telade_ranking);
        btnNovamente = findViewById(R.id.btnNovamente);
        btnTelaIncial = findViewById(R.id.btnTelaInicial);
        lvNomes =(ListView) findViewById(R.id.lvNomes);
        lvPontos =(ListView) findViewById(R.id.lvPontos);
        ArrayList<String> arrayNome =getIntent().getStringArrayListExtra("arrayNome");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayNome);
        lvNomes.setAdapter(adaptador);

        ArrayList<Integer> arrayPontos = getIntent().getIntegerArrayListExtra("arrayPontos");
        ArrayAdapter<Integer> adaptadorPontos = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, arrayPontos);
        lvPontos.setAdapter(adaptadorPontos);
    }
    public void telaIncial(View view){
        Intent it_mainActivity = new Intent(this, MainActivity.class);
        it_mainActivity.putExtra("outroUser", true);
        ArrayList<String> arrayNome =getIntent().getStringArrayListExtra("arrayNome");
        it_mainActivity.putStringArrayListExtra("arrayNome",arrayNome);
        ArrayList<Integer> arrayPontos = getIntent().getIntegerArrayListExtra("arrayPontos");
        it_mainActivity.putIntegerArrayListExtra("arrayPontos",arrayPontos);
        startActivity(it_mainActivity);
        finish();
    }
    public void jogarNovamente(View view){
        Intent it_telaBrasil = new Intent(this, TelaBrasil.class);
        ArrayList<Integer> arrayPontos = getIntent().getIntegerArrayListExtra("arrayPontos");
        arrayPontos.add(0);
        it_telaBrasil.putIntegerArrayListExtra("arrayPontos", arrayPontos);
        ArrayList<String> arrayNome = getIntent().getStringArrayListExtra("arrayNome");
        arrayNome.add(arrayNome.get(arrayNome.size()-1));
        it_telaBrasil.putStringArrayListExtra("arrayNome", arrayNome);
        startActivity(it_telaBrasil);
        finish();
    }
}