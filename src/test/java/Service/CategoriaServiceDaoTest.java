package Service;

import dao.CategoriaDao;
import db.DB;
import model.Categoria;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.util.List;

public class CategoriaServiceDaoTest {
    private Connection conn;
    private CategoriaDao categoriaService;

    @BeforeEach
    public void setUp() {
        conn = DB.getConnection();
        categoriaService = new CategoriaServiceDaoJDBC(conn);
    }

//    @AfterEach
//    public void tearDown() {
//        DB.closeConnection();
//    }



    @Test
    public void deveInserirCategoria() {
        Categoria categoria = new Categoria(null, "categoriateste1");
        categoriaService.insert(categoria);
        Assertions.assertNotNull(categoria.getIdCategoria());
    }

    @Test
    public void deveAtualizarCategoria() {
        Categoria categoria = new Categoria(null, "categoriateste1");
        categoriaService.insert(categoria);
        categoria.setNome("categoriaatualizadateste");
        categoriaService.update(categoria);
        Categoria categoriaAtualizada = categoriaService.findById(categoria.getIdCategoria());
        Assertions.assertEquals(categoria, categoriaAtualizada);
    }

    @Test
    public void deveDeletarCategoriaPorId() {
        Categoria categoria = new Categoria(null, "categoriateste1");
        categoriaService.insert(categoria);
        Integer id = categoria.getIdCategoria();
        categoriaService.deleteById(id);
        Categoria deletaCategoria = categoriaService.findById(id);
        Assertions.assertNull(deletaCategoria);
    }

    @Test
    public void deveBuscarCategoriaPorId() {
        Categoria categoria = new Categoria(null, "categoriateste1");
        categoriaService.insert(categoria);
        Integer id = categoria.getIdCategoria();
        Categoria encontraCategoria = categoriaService.findById(id);
        Assertions.assertEquals(categoria, encontraCategoria);
    }

    @Test
    public void deveBuscarTodasAsCategorias() {
        List<Categoria> categorias = categoriaService.findAll();
        Assertions.assertNotNull(categorias);
        Assertions.assertFalse(categorias.isEmpty());
    }

}
