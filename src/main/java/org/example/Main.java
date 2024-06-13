package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Eletrônico");
            System.out.println("2. Adicionar Roupa");
            System.out.println("3. Adicionar Alimento");
            System.out.println("4. Remover Produto");
            System.out.println("5. Listar Produtos");
            System.out.println("6. Calcular Total");
            System.out.println("7. Gerar Relatório em Arquivo");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Adicionar Eletrônico
                    System.out.print("Nome: ");
                    String nomeE = scanner.nextLine();
                    System.out.print("Preço: ");
                    double precoE = scanner.nextDouble();
                    System.out.print("Garantia (meses): ");
                    int garantiaE = scanner.nextInt();
                    System.out.print("Quantidade: ");
                    int quantidadeE = scanner.nextInt();
                    scanner.nextLine(); 
                    carrinho.adicionarItem(new Eletronicos(nomeE, precoE, garantiaE, quantidadeE));
                    break;
                case 2:
                    // Adicionar Roupa
                    System.out.print("Nome: ");
                    String nomeR = scanner.nextLine();
                    System.out.print("Preço: ");
                    double precoR = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Tamanho: ");
                    String tamanhoR = scanner.nextLine();
                    System.out.print("Cor: ");
                    String corR = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidadeR = scanner.nextInt();
                    scanner.nextLine();
                    carrinho.adicionarItem(new Roupas(nomeR, precoR, tamanhoR, corR, quantidadeR));
                    break;
                case 3:
                    // Adicionar Alimento
                    System.out.print("Nome: ");
                    String nomeA = scanner.nextLine();
                    System.out.print("Preço: ");
                    double precoA = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.print("Data de Validade: ");
                    String dataValidadeA = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidadeA = scanner.nextInt();
                    scanner.nextLine();
                    carrinho.adicionarItem(new Alimento(nomeA, precoA, dataValidadeA, quantidadeA));
                    break;
                case 4:
                    // Remover Produto
                    System.out.print("Nome do Produto a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    carrinho.removerItem(nomeRemover);
                    break;
                case 5:
                    // Listar Produtos
                    System.out.println("Produtos no Carrinho:");
                    carrinho.listarItens();
                    break;
                case 6:
                    // Calcular Total
                    System.out.println("Total: " + carrinho.calcularTotal());
                    break;
                case 7:
                    // Gerar Relatório em Arquivo
                    System.out.print("Nome do Arquivo: ");
                    String nomeArquivo = scanner.nextLine();
                    carrinho.gerarArquivoTexto(nomeArquivo);
                    System.out.println("Relatório gerado com sucesso.");
                    break;
                case 8:
                    // Sair
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}