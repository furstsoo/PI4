package com.example.projetointegrador.connection;

import android.os.AsyncTask;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.XML;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.projetointegrador.repository.network.interfaces.ConnectionListener;

public class ConnectionAsyncTask extends AsyncTask<String, Void, String> {

    /*TODO
       Transplantar esta classe completamente para o presente projeto;
       Implementar as interfaces necessárias para enviar requisições assíncronas (ws do Jean).
     */

    private ConnectionListener listener;

    public ConnectionAsyncTask(ConnectionListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {

        String url = strings[0];

        try {
            URL urlConnection = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();

            return IOUtils.toString(inputStream, "utf-8");
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(listener != null) {
            try {
                JSONObject object = XML.toJSONObject(s);//new JSONObject(s);
                listener.onSuccess(object);
            } catch (Exception e) {
                listener.onError();
            }
        }
    }


}
