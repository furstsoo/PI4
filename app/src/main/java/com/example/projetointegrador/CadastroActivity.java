package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

  Spinner tpCadastro;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cadastro);

    Button salvar_btn = findViewById(R.id.btnProximoCadUser);
    tpCadastro = findViewById(R.id.spinTp_cadastro);

    ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tp_cadastro, android.R.layout.simple_spinner_item);
    tpCadastro.setAdapter(adapter);


    salvar_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(tpCadastro.getSelectedItemPosition() == 0){
          Intent intent = new Intent(CadastroActivity.this, FeedActivity.class);
          startActivity(intent);
        }
        else{
          Intent intent = new Intent(CadastroActivity.this, CadastrolocalActivity.class);
          startActivity(intent);
        }


      }
    });

  }
}
