package org.example;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Produto> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    public void removerItem(Produto produto) {
        itens.remove(produto);
    }

    public void listarItens() {
        for (Produto produto : itens) {
            System.out.println(produto.exibirDetalhes());
        }
    }

    public List<Produto> exportarListaProdutos() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : itens) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        return total;

}
