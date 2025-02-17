package com.betrybe.sistemadevotacao;

/**
 * Classe - Pessoa Eleitora.
 */

public class PessoaEleitora extends Pessoa {
  private String cpf;

  /**
   * Constructor.
   */

  public PessoaEleitora(String nome, String cpf) {
    super(nome);
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
