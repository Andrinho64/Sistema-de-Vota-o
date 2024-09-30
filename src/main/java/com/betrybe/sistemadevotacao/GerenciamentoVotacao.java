package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe de votação.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private ArrayList<String> cpfsComputados = new ArrayList<>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (isNumeroCandidatoExistente(numero)) {
      System.out.println("Número da pessoa candidata já utilizado!");
      return;
    }
    pessoasCandidatas.add(new PessoaCandidata(nome, numero));
  }

  private boolean isNumeroCandidatoExistente(int numero) {
    return pessoasCandidatas.stream().anyMatch(candidato -> candidato.getNumero() == numero);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (isCpfEleitorExistente(cpf)) {
      System.out.println("Pessoa eleitora já cadastrada!");
      return;
    }
    pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
  }

  private boolean isCpfEleitorExistente(String cpf) {
    return pessoasEleitoras.stream().anyMatch(eleitor -> eleitor.getCpf().equals(cpf));
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }

    PessoaCandidata candidato = getCandidatoPorNumero(numeroPessoaCandidata);
    if (candidato != null) {
      candidato.receberVoto();
      cpfsComputados.add(cpfPessoaEleitora);
    }
  }

  private PessoaCandidata getCandidatoPorNumero(int numero) {
    return pessoasCandidatas.stream()
                            .filter(candidato -> candidato.getNumero() == numero)
                            .findFirst()
                            .orElse(null);
  }

  @Override
  public void mostrarResultado() {
    int totalDeVotos = calcularTotalDeVotos();

    if (totalDeVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    pessoasCandidatas.forEach(candidato -> {
      String nome = candidato.getNome();
      int votoIndividual = candidato.getVotos();
      int porcentagem = Math.round((votoIndividual * 100) / totalDeVotos);
      System.out
      .println("Nome: " + nome + " - " + votoIndividual + " votos ( " + porcentagem + "% )");
    });

    System.out.println("Total de votos: " + totalDeVotos);
  }

  private int calcularTotalDeVotos() {
    return pessoasCandidatas.stream().mapToInt(PessoaCandidata::getVotos).sum();
  }
}