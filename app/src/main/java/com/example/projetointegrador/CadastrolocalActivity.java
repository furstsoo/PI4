package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CadastrolocalActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cadastrolocal);

    Button btnProximoLocalCad = findViewById(R.id.btnProximoLocalCad);

    btnProximoLocalCad.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(CadastrolocalActivity.this, LocalActivity.class);
        startActivity(intent);

        /*Intent foto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(foto);*/

      }
    });

    }
}
