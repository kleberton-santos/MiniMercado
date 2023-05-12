package model;

import java.util.List;
import java.util.Objects;

public class Caixa {
    private Integer idCaixa;
    private Double saldo;
    private Double valorPagamento;
    private StatusPagamento status;
    private Pedido pedido;
    List<Pedido> pedidoList;

    public Caixa() {
    }

    public Caixa(Integer idCaixa, Double saldo, Double valorPagamento, StatusPagamento status, Pedido pedido) {
        this.idCaixa = idCaixa;
        this.saldo = saldo;
        this.valorPagamento = valorPagamento;
        this.status = status;
        this.pedido = pedido;
    }

    public Integer getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(Integer idCaixa) {
        this.idCaixa = idCaixa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caixa caixa = (Caixa) o;
        return Objects.equals(idCaixa, caixa.idCaixa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCaixa);
    }

    @Override
    public String toString() {
        return "Caixa{" +
                "idCaixa=" + idCaixa +
                ", saldo=" + saldo +
                ", valorPagamento=" + valorPagamento +
                ", status=" + status +
                ", pedido=" + pedido +
                ", pedidoList=" + pedidoList +
                '}';
    }
}
