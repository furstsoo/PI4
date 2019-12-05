package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button loginBtn = findViewById(R.id.loginBtn);
    Button cadastroBtn = findViewById(R.id.cadastroBtn);
    Button feedBtn = findViewById(R.id.feedBtn);



    cadastroBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent intentCad = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(intentCad);
      }
    });

    loginBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intentLogin = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intentLogin);
      }
    });

    feedBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intentFeed = new Intent(MainActivity.this, FeedActivity.class);
        startActivity(intentFeed);
      }
    });

  }
}
