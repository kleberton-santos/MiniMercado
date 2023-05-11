package dao;

import model.Categoria;

import java.util.List;

public interface CategoriaDao {
    void insert(Categoria obj);
    void update(Categoria obj);
    void deleteById(Integer id);
    Categoria findById(Integer id);
    List<Categoria> findAll();
}
