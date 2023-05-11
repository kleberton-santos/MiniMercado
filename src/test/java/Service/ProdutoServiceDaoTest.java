package Service;

import dao.CategoriaDao;
import dao.ProdutoDao;
import db.DB;
import model.Categoria;
import model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

public class ProdutoServiceDaoTest {
    private Connection conn;
    private ProdutoDao produtoService;

    @BeforeEach
    public void setUp() {
        conn = DB.getConnection();
        produtoService = new ProdutoServiceDaoJDBC(conn);
    }

//    @AfterEach
//    public void tearDown() {
//        DB.closeConnection();
//    }

    @Test
    public void deveInserirProduto() {
        Categoria categoria = new Categoria(1,"TesteCategoria1");
        Produto produto = new Produto(null,"TesteProduto",15.00,categoria);
        produtoService.insert(produto);
        Assertions.assertNotNull(produto.getIdProduto());
    }

    @Test
    public void deveAtualizarProduto() {
        Categoria categoria = new Categoria(1,"TesteCategoria1");
        Produto produto = new Produto(null,"TesteProduto",15.00,categoria);
        produtoService.insert(produto);
        produto.setNome("testeatualizado");
        produto.setPreco(30.00);
        produto.setCategoria(categoria);
        produtoService.update(produto);
        Produto produtoAtualizado = produtoService.findById(produto.getIdProduto());
        Assertions.assertEquals(produto, produtoAtualizado);
    }

    @Test
    public void deveDeletarProdutoPorId() {
        Categoria categoria = new Categoria(1,"TesteCategoria1");
        Produto produto = new Produto(null,"TesteProduto",15.00,categoria);
        produtoService.insert(produto);
        Integer id = produto.getIdProduto();
        produtoService.deleteById(id);
        Produto deletaProduto = produtoService.findById(id);
        Assertions.assertNull(deletaProduto);
    }

    @Test
    public void deveBuscarProdutoPorId() {
        Categoria categoria = new Categoria(1,"TesteCategoria1");
        Produto produto = new Produto(null,"TesteProduto",15.00,categoria);
        produtoService.insert(produto);
        Integer id = produto.getIdProduto();
        Produto encontraProduto = produtoService.findById(id);
        Assertions.assertEquals(produto, encontraProduto);
    }

    @Test
    public void deveBuscarTodasOsProdutos() {
        List<Produto> produtos = produtoService.findAll();
        Assertions.assertNotNull(produtos);
        Assertions.assertFalse(produtos.isEmpty());
    }
}
