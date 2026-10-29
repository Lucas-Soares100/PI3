package com.example.errornull_proximaetapa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class TelaPerfil extends AppCompatActivity {

    private static final int REQUEST_CODE_QUESTIONARIO = 100;
    private ConstraintLayout cardResultado;
    private TextView tvResultadoPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_perfil);

        Button btnPerfil = findViewById(R.id.btnPerfil);
        Button btnCurso = findViewById(R.id.btnCurso);
        Button btnOport = findViewById(R.id.btnOport);
        Button btnAvisos = findViewById(R.id.btnAvisos);
        Button btnConfig = findViewById(R.id.btnConfig);
        Button btnCard = findViewById(R.id.btnCard);
        Button btnQuestionario = findViewById(R.id.btnQuestionario);
        
        cardResultado = findViewById(R.id.cardResultado);
        tvResultadoPerfil = findViewById(R.id.tvResultadoPerfil);

        btnCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irParaCurso = new Intent(TelaPerfil.this, TelaCurso.class);
                startActivity(irParaCurso);
            }
        });

        btnOport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irParaOport = new Intent(TelaPerfil.this, TelaOportunidades.class);
                startActivity(irParaOport);
            }
        });

        btnQuestionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPerfil.this, Questionario.class);
                startActivityForResult(intent, REQUEST_CODE_QUESTIONARIO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_QUESTIONARIO && resultCode == RESULT_OK && data != null) {
            String resultado = data.getStringExtra("RESULTADO_PERFIL");
            if (resultado != null) {
                tvResultadoPerfil.setText(resultado.toUpperCase());
                cardResultado.setVisibility(View.VISIBLE);
            }
        }
    }
}