package Service;

import db.DB;
import Exception.DbException;
import dao.PedidoDao;
import model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoServiceDaoJDBC implements PedidoDao {
    private Connection conn;
    public PedidoServiceDaoJDBC(Connection conn){
        this.conn = conn;
    }


    @Override
    public void insert(Pedido obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("INSERT INTO pedido "
                            + "(data, total) "
                            + "VALUES "
                            + "(?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setDate(1, new java.sql.Date(obj.getData().getTime()));
            st.setDouble(2,obj.getTotal());
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setIdPedido(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Erro inesperado nenhuma linha afetada");

            }
        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Pedido obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("UPDATE pedido "
                    + "SET data = ?, total = ? "
                    + "WHERE id_pedido = ?");
            st.setDate(1, new java.sql.Date(obj.getData().getTime()));
            st.setDouble(2, obj.getTotal());
            st.setInt(3, obj.getIdPedido());

            st.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM pedido WHERE id_pedido = ?");
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
    public Pedido findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT * FROM pedido WHERE id_pedido = ?");

            st.setInt(1,id);
            rs = st.executeQuery();
            if(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("id_pedido"));
                pedido.setData(rs.getDate("data"));
                pedido.setTotal(rs.getDouble("total"));
                return pedido;
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
    public List<Pedido> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT * FROM pedido ORDER BY total");
            rs = st.executeQuery();
            List<Pedido> list = new ArrayList<>();
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("id_pedido"));
                pedido.setData(rs.getDate("data"));
                pedido.setTotal(rs.getDouble("total"));
                list.add(pedido);
            }
            return list;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}




