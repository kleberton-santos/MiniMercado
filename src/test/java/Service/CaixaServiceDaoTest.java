package Service;

import dao.CaixaDao;
import dao.DaoFactory;
import dao.ProdutoDao;
import db.DB;
import model.Caixa;
import model.Pedido;
import model.StatusPagamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.Date;

public class CaixaServiceDaoTest {
    private Connection conn;
    private CaixaDao caixaService;

    @BeforeEach
    public void setUp() {
        conn = DB.getConnection();
        caixaService = new CaixaServiceDaoJDBC(conn);
    }

    @Test
    



}
