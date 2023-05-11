package model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.PrimitiveIterator;

public class Pedido {
    private Integer idPedido;
    private Date data;
    private Double total;
    List<ItemPedido> itemPedidoList;

    public Pedido() {
    }

    public Pedido(Integer idPedido, Date data, Double total){
        this.idPedido = idPedido;
        this.data = data;
        this.total = total;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }

    public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
        this.itemPedidoList = itemPedidoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(idPedido, pedido.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", data=" + data +
                ", total=" + total +
                ", itemPedidoList=" + itemPedidoList +
                '}';
    }
}
