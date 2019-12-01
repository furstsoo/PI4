package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projetointegrador.model.CEP;
import com.example.projetointegrador.repository.network.APIConnection;
import com.example.projetointegrador.repository.network.interfaces.RepositoryCepDataListener;

public class LocalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        final APIConnection apiConnection = new APIConnection();
        final TextView eCep = findViewById(R.id.eCEP);
        ImageButton btnCep = findViewById(R.id.btnCep);

        final TextView eEndereco, eNumero, eComplemento, eBairro, eCidade, eEstado, ePonRef;
        eEndereco = findViewById(R.id.eEndereco);
        eNumero = findViewById(R.id.eNumero);
        eComplemento = findViewById(R.id.eComplemento);
        eBairro = findViewById(R.id.eBairro);
        eCidade = findViewById(R.id.eCidade);
        eEstado = findViewById(R.id.eEstado);
        ePonRef = findViewById(R.id.ePonRef);


        btnCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eCep.getText() != null && !eCep.getText().toString().isEmpty()) {//TODO tratamento de CPF válido
                    final String cep = eCep.getText().toString();
                    final RepositoryCepDataListener cepDataListener = new RepositoryCepDataListener() {
                        @Override
                        public void onSuccess(CEP cep) {
                            eEndereco.setText(cep.getLogradouro());
                            eNumero.setText(cep.getComplemento());
                            //eComplemento
                            eBairro.setText(cep.getBairro());
                            eCidade.setText(cep.getLocalidade());
                            eEstado.setText(cep.getUf());
                        }

                        @Override
                        public void onError() {

                        }
                    };
                    apiConnection.getDadosCep(cep, cepDataListener );

                }


            }
        });

    }

    public void apiCep () {

    }
}
