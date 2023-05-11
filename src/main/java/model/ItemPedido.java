package model;

import java.util.Objects;

public class ItemPedido {
    private Integer idItemPedido;
    private Integer quantidade;
    private Pedido pedido;
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(Integer idItemPedido, Integer quantidade, Pedido pedido, Produto produto) {
        this.idItemPedido = idItemPedido;
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.produto = produto;
    }

    public Integer getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(Integer idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(idItemPedido, that.idItemPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItemPedido);
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "idItemPedido=" + idItemPedido +
                ", quantidade=" + quantidade +
                ", pedido=" + pedido +
                ", produto=" + produto +
                '}';
    }
}
