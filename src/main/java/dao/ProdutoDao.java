package dao;

import model.Produto;

import java.util.List;

public interface ProdutoDao {
    void insert(Produto obj);
    void update(Produto obj);
    void deleteById(Integer id);
    Produto findById(Integer id);
    List<Produto> findAll();
}
