package com.example.projetointegrador.model;

import java.io.Serializable;

public class Lugar  implements Serializable {
  private Integer id_lugar;
  private String titulo;
  private String descricao;
  private String CEP;
  private String endereco;
  private String numero;
  private String complemento;
  private String bairro;
  private String cidade;
  private String estado;
  private String ponto_ref;
  private Integer usuario;


  public Lugar() {
  }

  public Lugar(Integer id_lugar, String titulo, String descricao, String CEP, String endereco, String numero, String complemento, String bairro, String cidade, String estado, String ponto_ref, Integer usuario) {
    this.id_lugar = id_lugar;
    this.titulo = titulo;
    this.descricao = descricao;
    this.CEP = CEP;
    this.endereco = endereco;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.ponto_ref = ponto_ref;
    this.usuario = usuario;
  }

  public Lugar(String titulo, String descricao, String CEP, String endereco, String numero, String complemento, String bairro, String cidade, String estado, String ponto_ref, Integer usuario) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.CEP = CEP;
    this.endereco = endereco;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.ponto_ref = ponto_ref;
    this.usuario = usuario;
  }

  public Integer getId_lugar() {
    return id_lugar;
  }

  public void setId_lugar(Integer id_lugar) {
    this.id_lugar = id_lugar;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getCEP() {
    return CEP;
  }

  public void setCEP(String CEP) {
    this.CEP = CEP;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
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

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getPonto_ref() {
    return ponto_ref;
  }

  public void setPonto_ref(String ponto_ref) {
    this.ponto_ref = ponto_ref;
  }

  public Integer getUsuario() {
    return usuario;
  }

  public void setUsuario(Integer usuario) {
    this.usuario = usuario;
  }
}
