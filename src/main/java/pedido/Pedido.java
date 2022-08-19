

package pedido;

import java.util.ArrayList;

public class Pedido {

    private int id;
    private ArrayList<ItemPedido> itens;
    private Cliente cliente;

    private int quantidade = 0 ;

    private int indice =0 ;


    public Pedido(int id, ArrayList<ItemPedido> itens, Cliente cliente) {
        this.id = id;
        this.itens = itens;
        this.cliente = cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public int getId() {
        return this.id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public double calcularTotal(Cardapio cardapio) {
        return itens.stream()
                .map(itemPedido -> {
                    final var shake = itemPedido.getShake();
                    final var adicionais = shake.getAdicionais();
                    final var precoBase = cardapio.buscarPreco(shake.getBase()) * shake.getTipoTamanho().multiplicador;
                    final var precoAdicionais = adicionais.stream().map(cardapio::buscarPreco).reduce(0.0, Double::sum);
                    return ((precoBase + precoAdicionais) * itemPedido.getQuantidade());
                })
                .reduce(0.0, Double::sum);
    }


    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado) {
        if(itemExistePedido(itemPedidoAdicionado)){
            itemPedidoAdicionado.setQuantidade(quantidade + itemPedidoAdicionado.getQuantidade());
            itens.set(indice, itemPedidoAdicionado);
        } else{
            itens.add(itemPedidoAdicionado);
        }
    }

    public void removeItemPedido(ItemPedido itemPedidoRemovido) {
       if(!itemExistePedido(itemPedidoRemovido)){
           throw new IllegalArgumentException("Item nao existe no pedido.");
       } else {
           itemPedidoRemovido.setQuantidade(quantidade - 1);
           itens.set(indice, itemPedidoRemovido);
           if(quantidade - 1 <= 0){
               itens.remove(itemPedidoRemovido);
           }
       }

    }

    private boolean itemExistePedido (ItemPedido itemPedidoAdicionado) {
        for (ItemPedido item : itens) {
            if (item.getShake().toString().equals(itemPedidoAdicionado.getShake().toString())) {
               quantidade = item.getQuantidade();
               indice = itens.indexOf(item);
               return true;
            }
        } return  false;
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}