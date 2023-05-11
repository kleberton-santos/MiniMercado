package Service;

import db.DB;
import Exception.DbException;
import model.*;
import dao.ItemPedidoDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemPedidoServiceDaoJDBC implements ItemPedidoDao {
    private Connection conn;
    public ItemPedidoServiceDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(ItemPedido obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO itempedido "
                            + "(quantidade, id_pedido, id_produto) "
                            + "VALUES "
                            + "(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, obj.getQuantidade());
            st.setInt(2, obj.getPedido().getIdPedido());
            st.setInt(3,obj.getProduto().getIdProduto());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setIdItemPedido(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Erro inesperado, nenhuma linha afetada.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(ItemPedido obj) {

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM itempedido WHERE id_itempedido = ?");
            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new DbException("O registro não foi encontrado.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public ItemPedido findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT itempedido.*, pedido.total, produto.nome AS nome_produto "
                            +"FROM itempedido "
                            +"INNER JOIN pedido ON itempedido.id_pedido = pedido.id_pedido "
                            +"INNER JOIN produto ON itempedido.id_produto = produto.id_produto "
                            +"WHERE itempedido.id_itempedido = ?");
            st.setInt(1,id);
            rs = st.executeQuery();
            if (rs.next()) {
                ItemPedido ip = new ItemPedido();
                ip.setIdItemPedido(rs.getInt("id_itempedido"));
                ip.setQuantidade(rs.getInt("quantidade"));
                Pedido pedido = new Pedido(null,new Date(),100.00);
                ip.setPedido(pedido);
                Produto produto = new Produto(null,"arroz",10.00,new Categoria(null,"Limpeza"));
                ip.setProduto(produto);
                return ip;

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
    public List<ItemPedido> findAll() {
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        try{
//            st = conn.prepareStatement(
//                    "SELECT * FROM itempedido ORDER BY valor");
//            rs = st.executeQuery();
//            List<ItemPedido> list = new ArrayList<>();
//            while(rs.next()){
//                ItemPedido itemPedido = new ItemPedido();
//                itemPedido.setIdItemPedido(rs.getInt("id_itempedido"));
//                itemPedido.setQuantidade(rs.getInt("quantidade"));
//                itemPedido.setPedido(rs.getInt("id_pedido"));
//                list.add(itemPedido);
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
        return null;
    }

}



















