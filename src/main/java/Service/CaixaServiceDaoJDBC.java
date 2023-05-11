package Service;
import dao.CaixaDao;
import db.DB;
import Exception.DbException;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaixaServiceDaoJDBC implements CaixaDao {
    private Connection conn;
    private Double saldo;
    public CaixaServiceDaoJDBC(Connection conn){
        this.conn = conn;
    }


    @Override
    public void insert(Caixa obj) {

    }

    @Override
    public void update(Caixa obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Caixa findById(Integer id) {
        return null;
    }

    @Override
    public List<Caixa> findAll() {
        return null;
    }
}
