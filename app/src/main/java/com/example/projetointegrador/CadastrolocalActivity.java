package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetointegrador.model.Geral;
import com.example.projetointegrador.model.Lugar;


public class CadastrolocalActivity extends AppCompatActivity {



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cadastrolocal);

    Button btnProximoLocalCad = findViewById(R.id.btnProximoLocalCad);

    ImageButton btnHomeCL = findViewById(R.id.iBtnHomeCadL);

    btnHomeCL.setOnClickListener(new View.OnClickListener(){

      @Override
      public void onClick(View v) {
        Intent intent = new Intent(CadastrolocalActivity.this, FeedActivity.class);
        startActivity(intent);
      }
    });



    btnProximoLocalCad.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Geral geral = (Geral) getIntent().getSerializableExtra("geral");
        Intent intent = new Intent(CadastrolocalActivity.this, LocalActivity.class);

        intent.putExtra("geral", atualizaGeral(geral));
        startActivity(intent);

      }
    });
  }

  private Geral atualizaGeral(Geral geral) {

    EditText taTitulo = findViewById(R.id.taTitulo),
            taDescricao = findViewById(R.id.taDescricao);

    Lugar lugar = new Lugar();
    lugar.setTitulo(taTitulo.getText().toString());
    lugar.setDescricao(taDescricao.getText().toString());
    geral.setLugar(lugar);

    return geral;
  }
}
