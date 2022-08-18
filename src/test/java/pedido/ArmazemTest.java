package pedido;

import armazem.Armazem;
import ingredientes.Ingrediente;
import ingredientes.TipoTopping;
import ingredientes.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.Assert.assertEquals;
clea

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArmazemTest {

    Armazem armazem;

    @BeforeEach
    void setup() throws IllegalArgumentException{
        armazem = new Armazem();
        Ingrediente ingrediente = new Topping(TipoTopping.Mel);
        armazem.cadastrar(ingrediente);
        armazem.adicionarQuantidadeDoIngredienteEmEstoque(ingrediente, 2);

    }

    @Test
    public void test_cadastrar_ingrediente_estoque()  {

        Ingrediente ingrediente = new Topping(TipoTopping.Mel);
        armazem.cadastrar(ingrediente);
        long quantidade = armazem.consultarQuantidadeDoIngredienteEmEstoque(ingrediente);
        assertEquals(0, quantidade);;
        
     }

    @Test
     public void test_descadastrar_ingrediente_estoque(){


    }


    @Test
    public void test_adicionar_quantidade_ingrediente_estoque(){

    }

    @Test
    public void test_reduzir_quantidade_ingrediente_estoque(){

    }

    @Test
    public void test_consultar_quantidade_ingrediente_estoque(){

    }

}



