package com.example.projetointegrador.model;

import java.io.Serializable;
import java.util.List;

public class Geral implements Serializable {

  private List<Fotos> fotos;
  private Lugar lugar;
  private List<Telefone> telefone;
  private Usuario usuario;

  public List<Fotos> getFotos() {
    return fotos;
  }

  public void setFotos(List<Fotos> fotos) {
    this.fotos = fotos;
  }

  public Lugar getLugar() {
    return lugar;
  }

  public void setLugar(Lugar lugar) {
    this.lugar = lugar;
  }

  public List<Telefone> getTelefone() {
    return telefone;
  }

  public void setTelefone(List<Telefone> telefone) {
    this.telefone = telefone;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
