package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class FeedActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_feed);

    ImageButton btnAdd = findViewById(R.id.iBtnAdd),
            btnHome = findViewById(R.id.iBtnHome);

    btnHome.setOnClickListener(new View.OnClickListener(){

      @Override
      public void onClick(View v) {
        Intent intent = new Intent(FeedActivity.this, FeedActivity.class);
        startActivity(intent);
      }
    });

    btnAdd.setOnClickListener(new View.OnClickListener(){

      @Override
      public void onClick(View v) {

        Intent intent = new Intent(FeedActivity.this, CadastrolocalActivity.class);
        startActivity(intent);

      }
    });




  }
}
