package com.example.projetointegrador.model;

import java.io.Serializable;

public class Fotos implements Serializable {
  private Integer id_imagem;
  private byte[] imagem;
  private Integer id_lugar;

  public Fotos() {
  }

  public Fotos(Integer id_imagem, byte[] imagem, Integer id_lugar) {
    this.id_imagem = id_imagem;
    this.imagem = imagem;
    this.id_lugar = id_lugar;
  }

  public Fotos(byte[] imagem, Integer id_lugar) {
    this.imagem = imagem;
    this.id_lugar = id_lugar;
  }

  public Integer getId_imagem() {
    return id_imagem;
  }

  public void setId_imagem(Integer id_imagem) {
    this.id_imagem = id_imagem;
  }

  public byte[] getImagem() {
    return imagem;
  }

  public void setImagem(byte[] imagem) {
    this.imagem = imagem;
  }

  public Integer getId_lugar() {
    return id_lugar;
  }

  public void setId_lugar(Integer id_lugar) {
    this.id_lugar = id_lugar;
  }
}
