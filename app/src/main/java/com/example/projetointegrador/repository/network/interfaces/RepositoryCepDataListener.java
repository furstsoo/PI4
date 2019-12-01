package com.example.projetointegrador.repository.network.interfaces;

import com.example.projetointegrador.model.CEP;

import java.util.ArrayList;
import org.json.JSONObject;

public interface RepositoryCepDataListener {
    void onSuccess (CEP cep);
    //void onSuccess (JSONObject object);
    void onError ();
}
