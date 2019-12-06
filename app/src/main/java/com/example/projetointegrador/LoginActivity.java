package com.example.projetointegrador;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetointegrador.model.Geral;
import com.example.projetointegrador.repository.APIConnection;
import com.example.projetointegrador.repository.Interface.ConnectionListener;
import com.example.projetointegrador.repository.Interface.RepositoryGeralListener;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {


  private AlertDialog alertaLogin;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    Button entrar = findViewById(R.id.EntrarBtn);
    final AlertDialog.Builder builderLogin = new AlertDialog.Builder(this);


    entrar.setOnClickListener(new View.OnClickListener() {

      TextView senha = findViewById(R.id.idSenha),
              email = findViewById(R.id.idEmail);

      @Override
      public void onClick(View v) {

        if ((senha.getText() != null && !senha.getText().toString().equals("Senha"))  && (email.getText() != null && !email.getText().toString().equals("Email"))) {
          String url = "http://192.168.0.2:8080/PI4WebService/webresources/pi/Usuario/get/logar/" + email.getText().toString() + "/" + senha.getText().toString();
          APIRoom8(url);
        } else {
          builderLogin.setMessage("O login e a senha devem ser digitados.")
                  .setTitle("Valor necessário");
          builderLogin.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
              senha.getOnFocusChangeListener();
            }
          });
          alertaLogin = builderLogin.create();
          alertaLogin.show();


        }
      }
    });

  }

  private void APIRoom8(String url) {
    boolean result = false;
    new APIConnection().getRoom8(url, new ConnectionListener() {

      @Override
      public void onSuccess(JSONObject object) {

      }

      @Override
      public void onError() {

      }

      @Override
      public void onSucess(Object object) {
        boolean rLogin = false;
        rLogin = (boolean) object;

        if(rLogin){
          Intent intent = new Intent(LoginActivity.this, FeedActivity.class);
          startActivity(intent);
        }
        else{
          Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
          startActivity(intent);
        }

      }
    });
  }
}
