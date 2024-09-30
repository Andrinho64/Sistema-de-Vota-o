package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe - Principal.
 */
public class Principal {
  private final GerenciamentoVotacao gerenciamentoVotacao;

  public Principal() {
    this.gerenciamentoVotacao = new GerenciamentoVotacao();
  }

  public static void main(String[] args) {
    Principal principal = new Principal();
    principal.executar();
  }

  /**
   * Método que executa o sistema de votação.
   */
  public void executar() {
    Scanner scanner = new Scanner(System.in);

    try {
      cadastrarCandidatos(scanner);
      cadastrarEleitores(scanner);
      realizarVotacao(scanner);
    } finally {
      scanner.close();
    }
  }

  private void cadastrarCandidatos(Scanner scanner) {
    while (true) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      int opcao = scanner.nextInt();

      if (opcao == 1) {
        System.out.print("Entre com o nome da pessoa candidata: ");
        String nomeCandidato = scanner.next();
        System.out.print("Entre com o número da pessoa candidata: ");
        int numeroCandidato = scanner.nextInt();
        gerenciamentoVotacao.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
      } else if (opcao == 2) {
        break;
      }
    }
  }

  private void cadastrarEleitores(Scanner scanner) {
    while (true) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      int opcao = scanner.nextInt();

      if (opcao == 1) {
        System.out.print("Entre com o nome da pessoa eleitora: ");
        String nomeEleitor = scanner.next();
        System.out.print("Entre com o CPF da pessoa eleitora: ");
        String cpfEleitor = scanner.next();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nomeEleitor, cpfEleitor);
      } else if (opcao == 2) {
        break;
      }
    }
  }

  private void realizarVotacao(Scanner scanner) {
    while (true) {
      exibirMenuVotacao();
      int opcao = scanner.nextInt();

      if (opcao == 1) {
        processarVoto(scanner);
      } else if (opcao == 2) {
        gerenciamentoVotacao.mostrarResultado();
      } else if (opcao == 3) {
        gerenciamentoVotacao.mostrarResultado();
        break;
      }
    }
  }

  private void exibirMenuVotacao() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Votar");
    System.out.println("2 - Resultado Parcial");
    System.out.println("3 - Finalizar Votação");
    System.out.print("Opção: ");
  }

  private void processarVoto(Scanner scanner) {
    System.out.print("Entre com o CPF da pessoa eleitora: ");
    String cpfEleitor = scanner.next();
    System.out.print("Entre com o número da pessoa candidata: ");
    int numeroCandidato = scanner.nextInt();
    gerenciamentoVotacao.votar(cpfEleitor, numeroCandidato);
  }
}