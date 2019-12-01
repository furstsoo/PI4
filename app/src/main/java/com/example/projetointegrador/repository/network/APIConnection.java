package com.example.projetointegrador.repository.network;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import com.example.projetointegrador.connection.ConnectionAsyncTask;
import com.example.projetointegrador.model.CEP;
import com.example.projetointegrador.repository.network.interfaces.ConnectionListener;
import com.example.projetointegrador.repository.network.interfaces.RepositoryCepDataListener;

public class APIConnection {

    public void getDadosCep(final String cepInformado, final RepositoryCepDataListener listener){

        ConnectionAsyncTask connectionAsyncTask = new ConnectionAsyncTask(new ConnectionListener() {
            @Override
            public void onSuccess(JSONObject object) {

                CEP cep = new CEP();
                try {
                    JSONObject cepObject = object.getJSONObject("");
                    cep.setCep(cepObject.getString("cep"));
                    cep.setLogradouro(cepObject.getString("logradouro"));
                    cep.setComplemento(cepObject.getString("complemento"));
                    cep.setBairro(cepObject.getString("bairro"));
                    cep.setLocalidade(cepObject.getString("localidade"));
                    cep.setUf(cepObject.getString("uf"));
                    cep.setUnidade(cepObject.getString("unidade"));
                    cep.setIbge(cepObject.getString("ibge"));
                    cep.setGia(cepObject.getString("gia"));
                }
                catch (Exception e){}
                listener.onSuccess(cep);
            }

            @Override
            public void onError() {
                listener.onError();
            }
        });
        connectionAsyncTask.execute("viacep.com.br/ws/" + cepInformado + "/json/");
    }

}

