package com.betrybe.sistemadevotacao;

/**
 * Classe - Pessoa Candidata.
 */

public class PessoaCandidata {
  public String nome;
  public int numero;
  public int votos;

  /**
   * Constructor.
   */

  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void recebeVoto() {
    this.votos++;
  }
}
