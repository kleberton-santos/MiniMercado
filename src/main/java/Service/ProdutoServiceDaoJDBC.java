package Service;

import db.DB;
import Exception.DbException;
import dao.ProdutoDao;
import model.Categoria;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoServiceDaoJDBC implements ProdutoDao {
    private Connection conn;

    public ProdutoServiceDaoJDBC(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Produto obj) {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO produto "
                            + "(nome, preco, id_categoria) "
                            + "VALUES "
                            + "(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getCategoria().getIdCategoria());
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setIdProduto(id);
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
    public void update(Produto obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "UPDATE produto "
                            + "SET nome = ?, preco = ?, id_categoria "
                            + "WHERE id_produto = ?");

            st.setString(1,obj.getNome());
            st.setDouble(2, obj.getPreco());
            st.setInt(3,obj.getCategoria().getIdCategoria());
            st.setInt(4,obj.getIdProduto());

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
            st = conn.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
            st.setInt(1, id);
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new DbException("Registro não encontrado");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Produto findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT produto.*, categoria.nome as categoria_nome "
                            + "FROM produto "
                            + "INNER JOIN categoria "
                            + "ON produto.ID_CATEGORIA = categoria.ID_CATEGORIA "
                            + "WHERE produto.ID_PRODUTO = ?;");

            st.setInt(1,id);
            rs = st.executeQuery();
            if(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("categoria_nome"));

                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setCategoria(categoria);
                return produto;
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
    public List<Produto> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT * FROM produto ORDER BY nome");
            rs = st.executeQuery();
            List<Produto> list = new ArrayList<>();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("nome"));

                produto.setCategoria(categoria);
                list.add(produto);
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

