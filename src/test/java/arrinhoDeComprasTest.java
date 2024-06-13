import org.example.CarrinhoDeCompras;
import org.example.Eletronicos;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class arrinhoDeComprasTest {

    private CarrinhoDeCompras carrinho;

    @Before
    public void setUp() {
        carrinho = new CarrinhoDeCompras();
    }

    @Test
    public void testAdicionarItem() {
        Eletronicos eletronico = new Eletronicos("Smartphone", 2999.0, 12, 1);
        carrinho.adicionarItem(eletronico);

        assertEquals(1, carrinho.itens.size());
        assertEquals("Celular", carrinho.itens.get(0).getNome());
    }

    @Test
    public void testRemoverItem() {
        Eletronicos eletronico = new Eletronicos("Smartphone", 2999.0, 12, 1);
        carrinho.adicionarItem(eletronico);

        carrinho.removerItem("Celular");

        assertEquals(0, carrinho.itens.size());
    }


    @Test
    public void testListarItens() {
        Eletronicos eletronico = new Eletronicos("Smartphone", 2999.0, 12, 1);
        carrinho.adicionarItem(eletronico);

        String expectedOutput = "Lista de Produtos no Carrinho:\n" +
                "-----------------------------------------------------------\n" +
                "Nome: Celular, Preço: 2999.0, Quantidade: 1, Garantia: 12 meses\n" +
                "-----------------------------------------------------------\n" +
                "Total: 2999.0\n";

        // Pegar saída 
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        carrinho.listarItens();

        assertEquals(expectedOutput, outContent.toString());
    }

}
