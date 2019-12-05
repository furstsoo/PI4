package com.example.projetointegrador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.projetointegrador.model.Geral;
import com.example.projetointegrador.model.Lugar;
import com.example.projetointegrador.model.ViaCEP;
import com.example.projetointegrador.repository.APIConnection;
import com.example.projetointegrador.repository.Interface.RepositoryCEPListener;

public class LocalActivity extends AppCompatActivity {


    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        Button btnCEP = findViewById(R.id.btnVisu);
        final EditText eCep = findViewById(R.id.eCEP);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        Button btnProx = findViewById(R.id.btnProxFotos);

        ImageButton btnHomeLocal = findViewById(R.id.iBtnHomeLocal);

        btnHomeLocal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocalActivity.this, FeedActivity.class);
                startActivity(intent);
            }
        });

        btnProx.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Geral geral = (Geral) getIntent().getSerializableExtra("geral");
                Intent intent = new Intent(LocalActivity.this, FotoActivity.class);
                intent.putExtra("geral", atualizaGeral(geral));
                startActivity(intent);

            }
        });

        btnCEP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(eCep.getText()!= null && !eCep.getText().toString().equals("CEP")){
                    buscaCEP(eCep.getText().toString());

                }
                else {

                    builder.setMessage("O valor do CEP deve ser digitado.")
                            .setTitle("Valor necessário");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });
                    alerta = builder.create();
                    alerta.show();
                }
            }
        });


    }
    private void buscaCEP(String CEP){
        new APIConnection().getCep(CEP, new RepositoryCEPListener() {

            @Override
            public void onError() {

            }

            @Override
            public void onSucess(ViaCEP cep) {


                EditText eCep = findViewById(R.id.eCEP),
                        eEndereco  = findViewById(R.id.eEndereco),
                        eComplemento = findViewById(R.id.eComplemento),
                        eBairro = findViewById(R.id.eBairro),
                        eCidade = findViewById(R.id.eCidade),
                        eEstado = findViewById(R.id.eEstado);

                eCep.setText(cep.getCep());
                eEndereco.setText(cep.getLongradouro());
                eComplemento.setText(cep.getComplemento());
                eBairro.setText(cep.getBairro());
                eCidade.setText(cep.getLocalidade());
                eEstado.setText(cep.getUf());
            }
        });

    }

    private Geral atualizaGeral(Geral geral){
        EditText eCep = findViewById(R.id.eCEP),
                eEndereco  = findViewById(R.id.eEndereco),
                eComplemento = findViewById(R.id.eComplemento),
                eBairro = findViewById(R.id.eBairro),
                eCidade = findViewById(R.id.eCidade),
                eEstado = findViewById(R.id.eEstado),
                eNumber = findViewById(R.id.eNumber),
                eReferencia = findViewById(R.id.eReferencia);

        Lugar lugar = geral.getLugar();
        lugar.setCEP(eCep.getText().toString());
        lugar.setEndereco(eEndereco.getText().toString());
        lugar.setComplemento(eComplemento.getText().toString());
        lugar.setBairro(eBairro.getText().toString());
        lugar.setCidade(eCidade.getText().toString());
        lugar.setEstado(eEstado.getText().toString());
        lugar.setNumero(eNumber.getText().toString());
        lugar.setPonto_ref(eReferencia.getText().toString());

        geral.setLugar(lugar);
        return geral;

    }
}
