package com.example.projetointegrador.repository.Interface;

import com.example.projetointegrador.model.Lugar;
import com.example.projetointegrador.model.ViaCEP;

public interface RepositoryCEPListener {
  void onError();
  void onSucess(ViaCEP cep);


}
