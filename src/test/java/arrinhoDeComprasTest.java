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
        assertEquals("Smartphone", carrinho.itens.get(0).getNome());
    }

}
