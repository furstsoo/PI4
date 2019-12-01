package com.example.projetointegrador.repository.network.interfaces;

import org.json.JSONObject;

public interface ConnectionListener {
    void onSuccess (JSONObject object);
    void onError ();
}
