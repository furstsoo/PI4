package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cadastro);

    Button proximo_btn = findViewById(R.id.proximo_btn);


    proximo_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent intent = new Intent(CadastroActivity.this, CadastrolocalActivity.class);
        startActivity(intent);
      }
    });

  }
}
