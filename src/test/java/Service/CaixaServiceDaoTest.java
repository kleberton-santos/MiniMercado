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
    public void deveRetornarPedidoSemPagamento(){
        Pedido pedido = new Pedido(1,new Date(),10.0);
        Caixa caixa = new Caixa(1,5.0,0.0, StatusPagamento.PAGO,pedido);
        caixaService.finalizaPedido(pedido,caixa);
        Assertions.assertEquals(StatusPagamento.CANCELADO,caixa.getStatus());
        Assertions.assertEquals(5.0,caixa.getSaldo());
    }
    @Test
    public void deveFInalizarPedidoPagamentoMaiorQueTotal(){
        Pedido pedido = new Pedido(1,new Date(),100.0);
        Caixa caixa = new Caixa(1,0.0,150.0, StatusPagamento.PAGO,pedido);
        caixaService.finalizaPedido(pedido,caixa);
        Assertions.assertEquals(StatusPagamento.PAGO,caixa.getStatus());
        Assertions.assertEquals(100.0,caixa.getSaldo());
    }

    @Test
    public void deveFinalizarPedidoPagamentoTotal(){
        Pedido pedido = new Pedido(1,new Date(),100.0);
        Caixa caixa = new Caixa(1,0.0,150.0, StatusPagamento.PAGO,pedido);
        caixaService.finalizaPedido(pedido,caixa);
        Assertions.assertEquals(StatusPagamento.PAGO,caixa.getStatus());
       
    }



}
