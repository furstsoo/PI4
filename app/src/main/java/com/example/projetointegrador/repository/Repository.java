package com.example.projetointegrador.repository;

import android.content.Context;
import com.example.projetointegrador.repository.network.APIConnection;
import com.example.projetointegrador.repository.network.interfaces.RepositoryCepDataListener;

public class Repository {

    private static Repository repository;
    private static APIConnection apiConnection;

    private Repository() {
    }

    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
            apiConnection = new APIConnection();
        }
        return repository;

//        public void dadosCep (Context context, final RepositoryCepDataListener listener){
//
//        }
    }
}
