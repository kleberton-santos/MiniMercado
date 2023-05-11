package Service;

import dao.CategoriaDao;
import dao.ItemPedidoDao;
import db.DB;
import model.Categoria;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class ItemPedidoServiceDaoTest {
    private Connection conn;
    private ItemPedidoDao itemPedidoService;

    @BeforeEach
    public void setUp() {
        conn = DB.getConnection();
        itemPedidoService = new ItemPedidoServiceDaoJDBC(conn);
    }

//    @AfterEach
//    public void tearDown() {
//        DB.closeConnection();
//    }



    @Test
    public void deveInserirItemPedido() {
        Pedido pedido = new Pedido(1,new Date(),10.00);
        Categoria categoria = new Categoria(1,"TesteCategoria");
        Produto produto = new Produto(1,"TesteProduto",10.00,categoria);
        ItemPedido itemPedido = new ItemPedido(null, 10,pedido,produto);
        itemPedidoService.insert(itemPedido);
        Assertions.assertNotNull(itemPedido.getIdItemPedido());
    }

    @Test
    public void deveAtualizarItemPedido() {
        Pedido pedido = new Pedido(1,new Date(),10.00);
        Categoria categoria = new Categoria(1,"TesteCategoria");
        Produto produto = new Produto(1,"TesteProduto",10.00,categoria);
        ItemPedido itemPedido = new ItemPedido(null, 10,pedido,produto);
        itemPedidoService.insert(itemPedido);
        itemPedido.setQuantidade(20);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedidoService.update(itemPedido);
        ItemPedido itemPedidoAtualizado = itemPedidoService.findById(itemPedido.getIdItemPedido());
        Assertions.assertEquals(itemPedido, itemPedidoAtualizado);
    }

    @Test
    public void deveDeletarItemPedidoPorId() {
        Pedido pedido = new Pedido(1,new Date(),10.00);
        Categoria categoria = new Categoria(1,"TesteCategoria");
        Produto produto = new Produto(1,"TesteProduto",10.00,categoria);
        ItemPedido itemPedido = new ItemPedido(null, 10,pedido,produto);
        itemPedidoService.insert(itemPedido);
        Integer id = itemPedido.getIdItemPedido();
        itemPedidoService.deleteById(id);
        ItemPedido deletaItemPedido = itemPedidoService.findById(id);
        Assertions.assertNull(deletaItemPedido);
    }

    @Test
    public void deveBuscarItemPedidoPorId() {
        Pedido pedido = new Pedido(1,new Date(),10.00);
        Categoria categoria = new Categoria(1,"TesteCategoria");
        Produto produto = new Produto(1,"TesteProduto",10.00,categoria);
        ItemPedido itemPedido = new ItemPedido(null, 10,pedido,produto);
        itemPedidoService.insert(itemPedido);
        Integer id = itemPedido.getIdItemPedido();
        ItemPedido encontraItemPedido = itemPedidoService.findById(id);
        Assertions.assertEquals(itemPedido, encontraItemPedido);
    }


}
