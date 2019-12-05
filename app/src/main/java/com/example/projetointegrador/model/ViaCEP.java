package com.example.projetointegrador.model;

public class ViaCEP {
  private String cep;
  private String longradouro;
  private String complemento;
  private String bairro;
  private String localidade;
  private String uf;

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getLongradouro() {
    return longradouro;
  }

  public void setLongradouro(String longradouro) {
    this.longradouro = longradouro;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }
}
