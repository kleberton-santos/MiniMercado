package dao;

import model.Caixa;
import model.Pedido;

import java.util.List;

public interface CaixaDao {

    void insert(Caixa obj);
    void update(Caixa obj);
    void deleteById(Integer id);
    Caixa findById(Integer id);
    List<Caixa> findAll();
    void finalizaPedido(Pedido pedido, Caixa caixa);

}
