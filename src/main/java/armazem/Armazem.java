package armazem;

import ingredientes.Ingrediente;

import java.util.TreeMap;

public class Armazem {


    private TreeMap<Ingrediente, Integer> estoque() {

        return this.estoque();
    }

    public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente) {

        if(estoque().get(ingrediente) == null){
            estoque().put(ingrediente, 0);
        } else {
            throw new IllegalArgumentException("Ingrediente já cadastrado.");
        }

    }


    public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente) {
        //TODO

    }

    public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) {
        //TODO

    }

    public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) {
        //TODO

    }

    public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente){
    //TODO
        return 0;
    }

    public void cadastrar(Ingrediente aveia) {
    }
}