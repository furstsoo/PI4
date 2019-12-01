package com.example.projetointegrador.model;

import java.util.ArrayList;

public class CEP {

    private int id;
    private ArrayList dadosCep;
    private String cep, uf, localidade, logradouro, bairro, unidade, ibge, complemento, gia;

    /* Exemplo de retorno :
    {
    "cep":"01001-000",
     "logradouro":"Praça da Sé",
     "complemento":"lado ímpar",
     "bairro":"Sé",
     "localidade":"São Paulo",
     "uf":"SP",
     "unidade":"",
     "ibge":"3550308",
     "gia":"1004"
    } */

    public CEP() {
    }

    public CEP(int id, ArrayList dadosCep, String cep, String uf, String localidade, String logradouro, String bairro, String unidade, String ibge, String complemento, String gia) {
        this.id = id;
        this.dadosCep = dadosCep;
        this.cep = cep;
        this.uf = uf;
        this.localidade = localidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.unidade = unidade;
        this.ibge = ibge;
        this.complemento = complemento;
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addDadosCep (ArrayList<CEP> dadosCep) {
        if (dadosCep != null)
            this.dadosCep.add(dadosCep);
    }

    public ArrayList getDadosCep() {
        return dadosCep;
    }

    public void setDadosCep(ArrayList dadosCep) {
        this.dadosCep = dadosCep;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
