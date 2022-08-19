package armazem;

import ingredientes.Ingrediente;

import java.util.Map;
import java.util.TreeMap;

public class Armazem {
    private Map<Ingrediente, Integer> estoque;
    public Armazem() {
        this.estoque = new TreeMap<>();
    }

    public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente) throws IllegalArgumentException {

        if (!ingredienteExiste(ingrediente)) {
            estoque.put(ingrediente, 0);
        } else {
            throw new IllegalArgumentException("Ingrediente já cadastrado.");
        }

    }

    public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente) {
        if (ingredienteExiste(ingrediente)) {
            estoque.remove(ingrediente, 0);
        } else {
            throw new IllegalArgumentException("Ingrediente nao encontrado.");
        }

    }

    public boolean ingredienteExiste(Ingrediente ingrediente) {

        return estoque.containsKey(ingrediente);
    }

    public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) {
        if (ingredienteExiste(ingrediente)) {
            estoque.put(ingrediente, quantidade);
        }
        // Criar uma validação de quantidade para verificar se é negativo
        if(quantidade >= 0){
            estoque.put(ingrediente, quantidade);
        } else {
            throw new IllegalArgumentException("Quantidade invalida.");
        }
    }

    public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) {
        if(ingredienteExiste(ingrediente)){
            estoque.replace(ingrediente, quantidade, quantidade - quantidade);
        }
        //verificação: o que está em estoque tem que ser maior
        // do que o que está mandando | Verificar se a
        // segunda quantidade é <= a primeira quantidade

        if(quantidade >= 0){
            estoque.replace(ingrediente, quantidade,quantidade - quantidade);
        }else{
            throw  new IllegalArgumentException("Estoque invalido.");
        }
    }

    public int consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente) {

        if (!ingredienteExiste(ingrediente)) {
            throw new IllegalArgumentException("Ingrediente nao existe.");
        }
        return estoque.get(ingrediente);
    }

}