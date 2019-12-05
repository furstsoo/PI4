package com.example.projetointegrador.model;

import java.io.Serializable;

public class TpCadastro  implements Serializable {
  private Integer id_tpCad;
  private String desc_cad;

  public TpCadastro() {
  }

  public TpCadastro(Integer id_tpCad, String desc_cad) {
    this.id_tpCad = id_tpCad;
    this.desc_cad = desc_cad;
  }

  public TpCadastro(String desc_cad) {
    this.desc_cad = desc_cad;
  }

  public Integer getId_tpCad() {
    return id_tpCad;
  }

  public void setId_tpCad(Integer id_tpCad) {
    this.id_tpCad = id_tpCad;
  }

  public String getDesc_cad() {
    return desc_cad;
  }

  public void setDesc_cad(String desc_cad) {
    this.desc_cad = desc_cad;
  }
}
