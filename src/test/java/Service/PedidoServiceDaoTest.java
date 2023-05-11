package Service;

import dao.CategoriaDao;
import dao.PedidoDao;
import db.DB;
import model.Categoria;
import model.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class PedidoServiceDaoTest {
    private Connection conn;
    private PedidoDao pedidoService;

    @BeforeEach
    public void setUp() {
        conn = DB.getConnection();
        pedidoService = new PedidoServiceDaoJDBC(conn);
    }

//    @AfterEach
//    public void tearDown() {
//        DB.closeConnection();
//    }


    @Test
    public void deveInserirPedido() {
        Pedido pedido = new Pedido(null,new Date(),100.00);
        pedidoService.insert(pedido);
        Assertions.assertNotNull(pedido.getIdPedido());
    }

    @Test
    public void deveAtualizarPedido() {
        Pedido pedido = new Pedido(null,new Date(),100.00);
        pedidoService.insert(pedido);
        pedido.setData(new Date());
        pedido.setTotal(200.00);
        pedidoService.update(pedido);
        Pedido pedidoAtualizado = pedidoService.findById(pedido.getIdPedido());
        Assertions.assertEquals(pedido, pedidoAtualizado);
    }

    @Test
    public void deveDeletarPedidoPorId() {
        Pedido pedido = new Pedido(null,new Date(),100.00);
        pedidoService.insert(pedido);
        Integer id = pedido.getIdPedido();
        pedidoService.deleteById(id);
        Pedido deletaPedido =  pedidoService.findById(pedido.getIdPedido());
        Assertions.assertNull(deletaPedido);
    }

    @Test
    public void deveBuscarPedidoPorId() {
        Pedido pedido = new Pedido(null,new Date(),100.00);
        pedidoService.insert(pedido);
        Integer id = pedido.getIdPedido();
        Pedido encontraPedidoId = pedidoService.findById(id);
        Assertions.assertEquals(pedido, encontraPedidoId);
    }

    @Test
    public void deveBuscarTodasOsPedidos() {
        List<Pedido> pedidos = pedidoService.findAll();
        Assertions.assertNotNull(pedidos);
        Assertions.assertFalse(pedidos.isEmpty());
    }
}
