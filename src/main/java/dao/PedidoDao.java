package dao;

import model.Pedido;

import java.util.List;

public interface PedidoDao {
    void insert(Pedido obj);
    void update(Pedido obj);
    void deleteById(Integer id);
    Pedido findById(Integer id);
    List<Pedido> findAll();
}

