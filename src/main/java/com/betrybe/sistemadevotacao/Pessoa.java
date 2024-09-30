package com.betrybe.sistemadevotacao;

/**
 * Classe - Pessoa.
 */

public abstract class Pessoa {
  protected String nome;

  public Pessoa(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  } 
}
