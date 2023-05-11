//package Service;
//import dao.CaixaDao;
//import db.DB;
//import Exception.DbException;
//import model.*;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CaixaServiceDaoJDBC implements CaixaDao {
//    private Connection conn;
//    private Double saldo;
//    public CaixaServiceDaoJDBC(Connection conn){
//        this.conn = conn;
//    }
//    @Override
//    public void insert(Caixa obj) {
//        PreparedStatement st = null;
//        try {
//            st = conn.prepareStatement(
//                    "INSERT INTO caixa "
//                            + "(saldo, ID_PAGAMENTO, ID_ESTOQUE) "
//                            + "VALUES "
//                            + "(?, ?, ?)",
//                    Statement.RETURN_GENERATED_KEYS);
//
//            st.setDouble(1, obj.getSaldo());
//            st.setInt(2, obj.getPagamento().getIdPagamento());
//            st.setInt(3,obj.getEstoque().getIdEstoque());
//
//            int rowsAffected = st.executeUpdate();
//
//            if (rowsAffected > 0) {
//                ResultSet rs = st.getGeneratedKeys();
//                if (rs.next()) {
//                    int id = rs.getInt(1);
//                    obj.setIdCaixa(id);
//                }
//                DB.closeResultSet(rs);
//            } else {
//                throw new DbException("Unexpected error! No rows affected.");
//            }
//        } catch (SQLException e) {
//            throw new DbException(e.getMessage());
//        } finally {
//            DB.closeStatement(st);
//        }
//    }
//
//    @Override
//    public void update(Caixa obj) {
//       PreparedStatement st = null;
//       try{
//           st = conn.prepareStatement(
//                   "UPDATE caixa "
//                   + "SET saldo = ?, id_pagamento = ?, id_estoque = ? "
//                   + "WHERE id_caixa = ?");
//                st.setDouble(1,obj.getSaldo());
//                st.setInt(2,obj.getPagamento().getIdPagamento());
//                st.setInt(3,obj.getEstoque().getIdEstoque());
//                st.setInt(4,obj.getIdCaixa());
//
//                st.executeUpdate();
//
//       }catch (SQLException e){
//           throw new DbException(e.getMessage());
//       }
//       finally {
//           DB.closeStatement(st);
//      }
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        PreparedStatement st = null;
//        try{
//            st = conn.prepareStatement("DELETE FROM caixa WHERE id_caixa = ?");
//            st.setInt(1, id);
//            st.executeUpdate();
//        }
//        catch (SQLException e){
//            throw new DbException(e.getMessage());
//        }
//        finally {
//            DB.closeStatement(st);
//        }
//    }
//
//    @Override  // Estoque retornando null - arrumar
//    public Caixa findById(Integer id) {
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        try{
//            st = conn.prepareStatement(
//                    "SELECT caixa.*, pagamento.valor AS valor_pagamento, estoque.quantidade AS estoque_quantidade, "
//                    + "produto.id_produto, produto.nome AS produto_nome, produto.preco "
//                    + "FROM caixa "
//                    + "INNER JOIN pagamento ON caixa.id_pagamento = pagamento.id_pagamento "
//                    + "INNER JOIN estoque ON caixa.id_estoque = estoque.id_estoque "
//                    + "INNER JOIN produto ON estoque.id_produto = produto.id_produto "
//                    +" WHERE caixa.id_pagamento = ?");
//
//                    st.setInt(1,id);
//                    rs = st.executeQuery();
//                    if(rs.next()){
//                        Pagamento pg = new Pagamento();
//                        pg.setIdPagamento(rs.getInt("id_pagamento"));
//                        pg.setValor(rs.getDouble("valor_pagamento"));
//                        Produto pd = new Produto();
//                        pd.setIdProduto(rs.getInt("id_produto"));
//                        pd.setNome(rs.getString("produto_nome"));
//                        pd.setPreco(rs.getDouble("PRECO"));
//                        Estoque es = new Estoque();
//                        es.setIdEstoque(rs.getInt("id_estoque"));
//                        es.setProduto(pd);
//                        es.setQuantidade(rs.getInt("estoque_quantidade"));
//                        es.setValor(rs.getDouble("valor_pagamento"));
//                        Caixa cx = new Caixa();
//                        cx.setIdCaixa(rs.getInt("id_caixa"));
//                        cx.setSaldo(rs.getDouble("saldo"));
//                        cx.setPagamento(pg);
//                        return cx;
//                    }
//                    return null;
//        }
//        catch (SQLException e){
//            throw new DbException(e.getMessage());
//        }
//        finally {
//            DB.closeStatement(st);
//            DB.closeResultSet(rs);
//        }
//    }
//
//
//    @Override
//    public List<Caixa> findAll() {
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        try{
//            st = conn.prepareStatement(
//                    "SELECT * FROM caixa ORDER BY saldo");
//            rs = st.executeQuery();
//            List<Caixa> list = new ArrayList<>();
//            while(rs.next()){
//                Caixa caixa = new Caixa();
//                caixa.setIdCaixa(rs.getInt("id_caixa"));
//                caixa.setSaldo(rs.getDouble("saldo"));
//                //caixa.setPagamento(rs.getInt(""));
//                list.add(caixa);
//            }
//            return list;
//        }
//        catch (SQLException e){
//            throw new DbException(e.getMessage());
//        }
//        finally {
//            DB.closeStatement(st);
//            DB.closeResultSet(rs);
//        }
//    }
//
//    @Override
//    public void atualizarSaldo(Pagamento pagamento, Estoque estoque) {
//        Double novoSaldo = this.saldo;
//        if (pagamento != null && pagamento.getValor() != null) {
//            novoSaldo += pagamento.getValor();
//        }
//        if (estoque != null && estoque.getValor() != null && estoque.getQuantidade() != null) {
//            novoSaldo -= estoque.getValor() * estoque.getQuantidade();
//        }
//        this.saldo = novoSaldo;
//
//    }
//
//}
