package com.example.projetointegrador.model;

import java.io.Serializable;

public class Usuario implements Serializable {
  private Integer id_user;
  private String nome;
  private String CPF;
  private String email;
  private String senha;
  private String tp_cadastro;

  public Usuario() {
  }

  public Usuario(Integer id_user, String nome, String CPF, String email, String senha, String tp_cadastro) {
    this.id_user = id_user;
    this.nome = nome;
    this.CPF = CPF;
    this.email = email;
    this.senha = senha;
    this.tp_cadastro = tp_cadastro;
  }

  public Usuario(String nome, String CPF, String email, String senha, String tp_cadastro) {
    this.nome = nome;
    this.CPF = CPF;
    this.email = email;
    this.senha = senha;
    this.tp_cadastro = tp_cadastro;
  }

  public Integer getId_user() {
    return id_user;
  }

  public void setId_user(Integer id_user) {
    this.id_user = id_user;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCPF() {
    return CPF;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getTp_cadastro() {
    return tp_cadastro;
  }

  public void setTp_cadastro(String tp_cadastro) {
    this.tp_cadastro = tp_cadastro;
  }
}
