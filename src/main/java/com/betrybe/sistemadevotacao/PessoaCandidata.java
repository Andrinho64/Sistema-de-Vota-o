package com.betrybe.sistemadevotacao;

/**
 * Classe - Pessoa Candidata.
 */

public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * Constructor.
   */

  public PessoaCandidata(String nome, int numero) {
    super(nome);
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
