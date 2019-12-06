package com.example.projetointegrador.repository.Interface;

import org.json.JSONObject;

public interface ConnectionListener {
  void onSuccess(JSONObject object);
  void onError();
  void onSucess(Object object);
}
