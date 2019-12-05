package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetointegrador.model.Geral;
import com.example.projetointegrador.model.Telefone;
import com.example.projetointegrador.model.Usuario;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends AppCompatActivity {

    Spinner tpCadastro;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cadastro);

    ImageButton home = findViewById(R.id.iBtnHomeCad);

    Button salvar_btn = findViewById(R.id.btnFinalizar);
    tpCadastro = findViewById(R.id.spinTp_cadastro);

    ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tp_cadastro, android.R.layout.simple_spinner_item);
    tpCadastro.setAdapter(adapter);
    EditText eNome = findViewById(R.id.eNome),
            eCPF = findViewById(R.id.eCPF),
            eContato = findViewById(R.id.eContato),
            eContato2 = findViewById(R.id.eContato2),
            eEmail = findViewById(R.id.eEmail),
            eSenha = findViewById(R.id.eSenha);

    home.setOnClickListener(new View.OnClickListener(){

      @Override
      public void onClick(View v) {
        Intent intent = new Intent(CadastroActivity.this, FeedActivity.class);
        startActivity(intent);

      }
    });

    salvar_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(tpCadastro.getSelectedItemPosition() == 0){
          Intent intent = new Intent(CadastroActivity.this, FeedActivity.class);

          Gson cadLoc = new Gson();
          String gson = cadLoc.toJson(geraGeral());
          //chamar api passando o gson

          startActivity(intent);

        }
        else {
          Intent intent = new Intent(CadastroActivity.this, CadastrolocalActivity.class);
          intent.putExtra("geral", geraGeral());
          startActivity(intent);

        }


      }
    });

  }

  private Geral geraGeral(){
    Geral geral = new Geral();
    geral.setUsuario(salvaDados());
    geral.setTelefone(salvaTelefone());
    return geral;
  }

  private Usuario salvaDados() {
    EditText eNome = findViewById(R.id.eNome),
            eCPF = findViewById(R.id.eCPF),
            eEmail = findViewById(R.id.eEmail),
            eSenha = findViewById(R.id.eSenha);

    Usuario user = new Usuario();
    user.setNome(eNome.getText().toString());
    user.setCPF(eCPF.getText().toString());
    user.setEmail(eEmail.getText().toString());
    user.setSenha(eSenha.getText().toString());
    user.setTp_cadastro(String.valueOf(tpCadastro.getSelectedItemPosition()));
    return user;
  }
  private List<Telefone> salvaTelefone(){
    EditText eContato = findViewById(R.id.eContato),
            eContato2 = findViewById(R.id.eContato2);
    Telefone tel = new Telefone();
    Telefone tel2 = new Telefone();
    tel.setTel(eContato.getText().toString());
    tel2.setTel(eContato2.getText().toString());
    List<Telefone> list = new ArrayList<>();
    list.add(tel);
    list.add(tel2);

    return list;
  }

}
