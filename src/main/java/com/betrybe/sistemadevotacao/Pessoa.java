package com.betrybe.sistemadevotacao;

/**
 * Classe - Pessoa.
 */

public abstract class Pessoa {
  protected String nome;

  public Pessoa(String nome) {
    this.nome = nome;
  }

  public Pessoa() {
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  } 
}
