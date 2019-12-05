package com.example.projetointegrador.model;

import java.io.Serializable;

public class Telefone implements Serializable {
 private Integer id_tel;
 private Integer id_user;
 private String tel;

  public Telefone() {
  }

  public Telefone(Integer id_tel, Integer id_user, String tel) {
    this.id_tel = id_tel;
    this.id_user = id_user;
    this.tel = tel;
  }

  public Telefone(Integer id_user, String tel) {
    this.id_user = id_user;
    this.tel = tel;
  }

  public Integer getId_tel() {
    return id_tel;
  }

  public void setId_tel(Integer id_tel) {
    this.id_tel = id_tel;
  }

  public Integer getId_user() {
    return id_user;
  }

  public void setId_user(Integer id_user) {
    this.id_user = id_user;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }
}
