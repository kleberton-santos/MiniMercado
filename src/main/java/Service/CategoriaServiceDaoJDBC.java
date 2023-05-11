package Service;

import dao.CategoriaDao;
import db.DB;
import model.Categoria;
import Exception.DbException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaServiceDaoJDBC implements CategoriaDao {
    private Connection conn;

    public CategoriaServiceDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Categoria obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("INSERT INTO categoria "
                                        + "(nome) "
                                        + "VALUES "
                                        + "(?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setIdCategoria(id);
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
    public void update(Categoria obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "UPDATE categoria "
                     + "SET nome = ? "
                     + "WHERE id_categoria = ?");

            st.setString(1,obj.getNome());
            st.setInt(2,obj.getIdCategoria());

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
        try{
            st = conn.prepareStatement("DELETE FROM categoria WHERE id_categoria = ?");
            st.setInt(1,id);
            int linhasAfetadas = st.executeUpdate();
            if(linhasAfetadas == 0){
                throw new DbException("Registro não encontrado");
            }
        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Categoria findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT * FROM categoria WHERE id_categoria = ?");

            st.setInt(1,id);
            rs = st.executeQuery();
            if(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("nome"));
                return categoria;
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
    public List<Categoria> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT * FROM categoria ORDER BY nome");
            rs = st.executeQuery();
            List<Categoria> list = new ArrayList<>();
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("nome"));
                list.add(categoria);
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

