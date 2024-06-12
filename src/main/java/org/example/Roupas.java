package org.example;

public class Roupas extends ProdutoBase {

    private String tamanho;
    private String cor;

    public Roupas(String nome, double preco, String tamanho, String cor, int quantidade) {
        super(nome, preco, quantidade);
        this.tamanho = tamanho;
        this.cor = cor;
    }

    public Roupas() {}

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String getTipo() {
        return "Roupas";
    }

    @Override
    public String exibirDetalhes() {
        return "Tipo: " + getTipo() + ", Nome: " + getNome() + ", Preço: " + getPreco() +
                ", Quantidade: " + getQuantidade() + ", Tamanho: " + tamanho + ", Cor: " + cor;
    }

}
