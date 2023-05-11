package dao;

import model.Caixa;

import java.util.List;

public interface CaixaDao {

    void insert(Caixa obj);
    void update(Caixa obj);
    void deleteById(Integer id);
    Caixa findById(Integer id);
    List<Caixa> findAll();

}
