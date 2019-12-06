package com.example.projetointegrador.repository.Interface;

import com.example.projetointegrador.model.Geral;

public interface RepositoryGeralListener {
    void onError();
    void onSucess(Geral geral);
}
