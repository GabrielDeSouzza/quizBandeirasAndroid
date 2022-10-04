package com.example.myquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Button btnIniciar;
    private EditText edtNomeUser;
    private ArrayList<String> arrayNome = new ArrayList<String>();
    private ArrayList<Integer> arrayPontos = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIniciar = findViewById(R.id.btnIniciar);
        edtNomeUser = findViewById(R.id.edtNomeUser);

        edtNomeUser.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent)
            {
                if(edtNomeUser.getText().length() > 1)
                {
                    btnIniciar.setEnabled(true);
                    return  true;
                }
                else if(edtNomeUser.getText().length() == 0)
                {
                    btnIniciar.setEnabled(false);
                }
                return false;
            }
        });

    }
    public void Exit(View view){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Deseja Realmente Sair?");
        alertDialog.setNegativeButton("Não", null);
        alertDialog.setPositiveButton("sim", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                finish();
            }
        });
        alertDialog.show();
    }
    public void iniciarQuiz(View view) {
        Intent it_TelaBrasil = new Intent(this, TelaBrasil.class);
        boolean outroUser = getIntent().getBooleanExtra("outroUser", false);
        if (outroUser == true) {
            ArrayList<Integer> arrayPontos2 = getIntent().getIntegerArrayListExtra("arrayPontos");
            ArrayList<String> arrayNome2 = getIntent().getStringArrayListExtra("arrayNome");
            arrayNome2.add(edtNomeUser.getText().toString());
            arrayPontos2.add(0);
            it_TelaBrasil.putStringArrayListExtra("arrayNome", arrayNome2);
            it_TelaBrasil.putIntegerArrayListExtra("arrayPontos",arrayPontos2);
        }
        else {
            arrayNome.add(edtNomeUser.getText().toString());
            arrayPontos.add(0);
            it_TelaBrasil.putStringArrayListExtra("arrayNome", arrayNome);
            it_TelaBrasil.putIntegerArrayListExtra("arrayPontos", arrayPontos);
        }
        startActivity(it_TelaBrasil);
    }


}