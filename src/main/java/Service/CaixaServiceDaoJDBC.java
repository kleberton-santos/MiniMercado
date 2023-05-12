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
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO caixa "
                            + "(saldo, valor_pagamento, id_pedido) "
                            + "VALUES "
                            + "(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setDouble(1, obj.getSaldo());
            st.setDouble(2, obj.getValorPagamento());
            st.setInt(3, obj.getPedido().getIdPedido());
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setIdCaixa(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Erro inesperado nenhuma linha afetada");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Caixa obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Caixa findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT caixa.*, pedido.total as pedidott "
                    + "FROM caixa "
                    + "INNER JOIN pedido "
                    + "ON caixa.id_pedido = pedido.id_pedido "
                    + "WHERE caixa.id_caixa = ?");

            st.setInt(1,id);
            rs = st.executeQuery();
            if(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("id_pedido"));
                pedido.setData(rs.getDate("DATA"));
                pedido.setTotal(rs.getDouble("total"));

                Caixa caixa = new Caixa();
                caixa.setIdCaixa(rs.getInt("id_caixa"));
                caixa.setSaldo(rs.getDouble("saldo"));
                caixa.setValorPagamento(rs.getDouble("valor_pagamento"));
                caixa.setPedido(pedido);
                return caixa;
            }
            return null;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Caixa> findAll() {
        return null;
    }

    @Override
    public void finalizaPedido(Pedido pedido, Caixa caixa) {
            Double valorFaltante = pedido.getTotal() - caixa.getValorPagamento();
            Double valorDelvolvido = caixa.getValorPagamento() - pedido.getTotal();
            if(caixa.getValorPagamento() == pedido.getTotal()){
                caixa.setValorPagamento(pedido.getTotal());
                caixa.setSaldo(caixa.getSaldo() + pedido.getTotal());
                caixa.setStatus(StatusPagamento.PAGO);
            } else if (caixa.getValorPagamento() > pedido.getTotal()) {
                caixa.setValorPagamento(pedido.getTotal());
                caixa.setSaldo(caixa.getSaldo() + pedido.getTotal());
                caixa.setStatus(StatusPagamento.PAGO);
                System.out.println("Valor do troco: " + valorDelvolvido);
            } else if (caixa.getValorPagamento() == 0){
                caixa.setStatus(StatusPagamento.CANCELADO);
                System.out.println("Pedido Cancelado");
            } else {
                caixa.setValorPagamento(caixa.getValorPagamento() + valorFaltante);
                caixa.setStatus(StatusPagamento.PENDENTE);
                System.out.println("Valor faltante a ser pago: " + valorFaltante);
            }
            caixa.setPedido(pedido);
    }

}
