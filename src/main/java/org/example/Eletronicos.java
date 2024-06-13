package org.example;

public class Eletronicos extends ProdutoBase {
    private int garantiaMeses;

    public Eletronicos(String nome, double preco, int garantiaMeses, int quantidade) {
        super(nome, preco, quantidade);
        this.garantiaMeses = garantiaMeses;
    }

    public Eletronicos() {}

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public String getTipo() {
        return "Eletrônico";
    }

    @Override
    public String exibirDetalhes() {
        return "Tipo: " + getTipo() + ", Nome: " + getNome() + ", Preço: " + getPreco() +
                ", Quantidade: " + getQuantidade() + ", Garantia: " + garantiaMeses + " meses";
    }

}
