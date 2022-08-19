package pedido;

import armazem.Armazem;
import ingredientes.TipoTopping;
import ingredientes.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.Assert.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArmazemTest {

    Armazem armazem;

    @BeforeEach
    void setup() throws IllegalArgumentException{
        armazem = new Armazem();
        Topping mel = new Topping(TipoTopping.Mel);
        //armazem.cadastrarIngredienteEmEstoque(mel);
        //armazem.adicionarQuantidadeDoIngredienteEmEstoque(mel, 2);
    }

    @Test
    public void test_cadastrar_ingrediente_estoque()  {

       Topping mel = new Topping(TipoTopping.Mel);
        armazem.cadastrarIngredienteEmEstoque(mel);
        long quantidade = armazem.consultarQuantidadeDoIngredienteEmEstoque(mel);
        assertEquals(0, quantidade);;
        
    }

    @Test
    public void test_cadastrar_ingrediente_estoque_ingrediente_existente() throws IllegalArgumentException{

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
              Topping mel = new Topping(TipoTopping.Mel);
               armazem.cadastrarIngredienteEmEstoque(mel);
               armazem.cadastrarIngredienteEmEstoque(mel);
                }
        );

        assertEquals(exception.getMessage(), "Ingrediente já cadastrado.");

    }

    @Test
     public void test_descadastrar_ingrediente_estoque(){
        Topping mel = new Topping(TipoTopping.Mel);
        armazem.cadastrarIngredienteEmEstoque(mel);
        armazem.descadastrarIngredienteEmEstoque(mel);
        assertFalse(armazem.ingredienteExiste(mel));

    }

    @Test
    public void test_descadastrar_ingrediente_estoque_ingrediente_nao_existente() throws IllegalArgumentException{

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                    Topping mel = new Topping(TipoTopping.Mel);
                    armazem.descadastrarIngredienteEmEstoque(mel);
                }
        );

        assertEquals(exception.getMessage(), "Ingrediente nao encontrado.");

    }

    @Test
    public void test_adicionar_quantidade_ingrediente_estoque(){
        Topping mel = new Topping(TipoTopping.Mel);
        armazem.cadastrarIngredienteEmEstoque(mel);
        armazem.adicionarQuantidadeDoIngredienteEmEstoque(mel, 2);

        assertEquals(2, armazem.consultarQuantidadeDoIngredienteEmEstoque(mel));

    }

    @Test
    public void test_reduzir_quantidade_ingrediente_estoque(){
        Topping mel = new Topping(TipoTopping.Mel);
        armazem.cadastrarIngredienteEmEstoque(mel);
        armazem.adicionarQuantidadeDoIngredienteEmEstoque(mel, 10);
        armazem.reduzirQuantidadeDoIngredienteEmEstoque(mel, 10);
        assertEquals(0, armazem.consultarQuantidadeDoIngredienteEmEstoque(mel));
    }

    @Test
    public void test_consultar_quantidade_ingrediente_estoque(){
        Topping mel = new Topping(TipoTopping.Mel);
        armazem.cadastrarIngredienteEmEstoque(mel);
        armazem.adicionarQuantidadeDoIngredienteEmEstoque(mel, 2);

        assertEquals(2, armazem.consultarQuantidadeDoIngredienteEmEstoque(mel));

    }

}



