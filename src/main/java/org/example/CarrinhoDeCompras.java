package org.example;

import org.example.Produto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    public List<Produto> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    public void removerItem(String nomeProduto) {
        // Verificar se nomeProduto não é nulo antes de converter para minúsculas
        if (nomeProduto == null) {
            System.out.println("Nome do produto não pode ser nulo.");
            return;
        }

        String nomeProdutoLower = nomeProduto.toLowerCase();

        // Criar uma lista temporária para armazenar produtos que serão removidos
        List<Produto> produtosRemover = new ArrayList<>();

        // Percorrer a lista de itens e adicionar produtos que correspondem ao nome para a lista temporária
        for (Produto produto : itens) {
            if (produto.getNome().toLowerCase().equals(nomeProdutoLower)) {
                produtosRemover.add(produto);
            }
        }

        // Remover os produtos da lista principal
        itens.removeAll(produtosRemover);

        if (!produtosRemover.isEmpty()) {
            System.out.println("Produtos removidos:");
            for (Produto produto : produtosRemover) {
                System.out.println(produto.getNome());
            }
            System.out.println("Novo total: " + calcularTotal()); // Mostrar o novo total após remoção
        } else {
            System.out.println("Nenhum produto encontrado com o nome: " + nomeProduto);
        }
    }

    public void listarItens() {
        System.out.println("Lista de Produtos no Carrinho:");
        System.out.println("-----------------------------------------------------------");
        for (Produto produto : itens) {
            if (produto != null) { // Verificar se o produto não é nulo antes de exibir
                System.out.println(produto.exibirDetalhes());
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("Total: " + calcularTotal());
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : itens) {
            if (produto != null) { // Verificar se o produto não é nulo antes de calcular o total
                total += produto.getPreco() * produto.getQuantidade();
            }
        }
        return total;
    }

    // Método simplificado para gerar arquivo de texto
    public void gerarArquivoTexto(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("Item\tQtd\tNome\tPreço\tSubTotal");
            int itemNumber = 1;
            for (Produto produto : itens) {
                if (produto != null) { // Verificar se o produto não é nulo antes de gravar no arquivo
                    double subTotal = produto.getPreco() * produto.getQuantidade();
                    writer.println(itemNumber + "\t" + produto.getQuantidade() + "\t" + produto.getNome() + "\t" + produto.getPreco() + "\t" + subTotal);
                    itemNumber++;
                }
            }
            writer.println("Total: " + calcularTotal());
        } catch (IOException e) {
            System.err.println("Erro ao gerar o arquivo: " + e.getMessage());
        }
    }
}
