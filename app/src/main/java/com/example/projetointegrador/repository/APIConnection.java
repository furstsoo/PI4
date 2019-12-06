package com.example.projetointegrador.repository;

import com.example.projetointegrador.connection.ConnectionAsyncTask;
import com.example.projetointegrador.model.ViaCEP;
import com.example.projetointegrador.repository.Interface.ConnectionListener;
import com.example.projetointegrador.repository.Interface.RepositoryCEPListener;
import com.example.projetointegrador.repository.Interface.RepositoryGeralListener;

import org.json.JSONException;
import org.json.JSONObject;

public class APIConnection {

  public void getCep(String cep, final RepositoryCEPListener listener){
    String url = "https://viacep.com.br/ws/"+cep+"/xml/";
    ConnectionAsyncTask connectionAsyncTask =
            new ConnectionAsyncTask(new ConnectionListener() {
              @Override
              public void onSuccess(JSONObject object) {
                try {
                  JSONObject viaCep = object.getJSONObject("xmlcep");

                  ViaCEP cep = new ViaCEP();
                  cep.setCep(viaCep.getString("cep"));
                  cep.setLongradouro(viaCep.getString("logradouro"));
                  cep.setComplemento(viaCep.getString("complemento"));
                  cep.setLocalidade(viaCep.getString("localidade"));
                  cep.setBairro(viaCep.getString("bairro"));
                  cep.setUf(viaCep.getString("uf"));

                  listener.onSucess(cep);
                }

                catch (JSONException e) {
                  listener.onError();
                }
              }

              @Override
              public void onError() {
              }

              @Override
              public void onSucess(Object object) {

              }
            });

    connectionAsyncTask.execute(url);
  }
  public void getRoom8(String urlWs, final ConnectionListener listener){
      String url = urlWs;
      ConnectionAsyncTask connectionAsyncTask =
              new ConnectionAsyncTask(new ConnectionListener() {

                @Override
                public void onSuccess(JSONObject object) {

                }

                @Override
                  public void onError() {

                    listener.onError();
                  }

                @Override
                public void onSucess(Object object) {
                  boolean rLogin = false;
                  rLogin = (boolean) object;

                }
              });

      connectionAsyncTask.execute(url);


  }


}
