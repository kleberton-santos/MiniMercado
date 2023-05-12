package aplication;

import dao.*;
import model.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MiniMercado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CaixaDao caixaDao = DaoFactory.createCaixaDao();
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();
        CategoriaDao categoriaDao = DaoFactory.createCategoriaDao();
        PedidoDao pedidoDao = DaoFactory.createPedidoDao();
        ItemPedidoDao itemPedidoDao = DaoFactory.createItemPedidoDao();


        System.out.println("===== Teste de um pedido =====");

        Pedido pedido1 = new Pedido(1,new Date(),10.0);
        Caixa caixa = new Caixa(null, 500.00, 0.0,StatusPagamento.PAGO,pedido1);
        caixaDao.finalizaPedido(pedido1,caixa);
        System.out.println("Valor Pago: " + caixa.getValorPagamento());
        System.out.println("Saldo do caixa: " + caixa.getSaldo());
        System.out.println("Status do Pedido: " + caixa.getStatus());




//        System.out.println("====================Categoria=========================");

//        System.out.println("=== Teste 1: Categoria insert ===");
//        Categoria newCategoria = new Categoria(null,"Açougue");
//        categoriaDao.insert(newCategoria);
//        System.out.println("Inserido novo Registro = " + newCategoria.getIdCategoria());

//        System.out.println("=== Teste 2: Categoria delete ===");
//        System.out.println("Entre com o ID para deletar:");
//        int id = sc.nextInt();
//        categoriaDao.deleteById(id);
//        System.out.println("Registro deletado");
//
//        System.out.println("=== Teste 3: Categoria update ===");
//        Categoria categoria = new Categoria();
//        categoria = categoriaDao.findById(1);
//        categoria.setNome("Padaria");
//        categoriaDao.update(categoria);
//        System.out.println("Registro atualizado");
//
//        System.out.println("=== Teste 4: Categoria findbyAll ===");
//        List<Categoria> list = categoriaDao.findAll();
//        for(Categoria categoria : list){
//            System.out.println(categoria);
//        }

//        System.out.println("=== Teste 5: Categoria findbyId ===");
//        Categoria categoria = categoriaDao.findById(1);
//        System.out.println(categoria);


//        System.out.println("====================Produto=========================");

//        System.out.println("=== Teste 1: Produto insert ===");
//        Produto produto = new Produto(null,"Salame",8.00,categoria);
//        produtoDao.insert(produto);
//        System.out.println("Inserido novo ID = " + produto.getIdProduto());
//
//        System.out.println("=== Teste 2: Produto delete ===");
//        System.out.println("Entre com o ID para deletar:");
//        int id = sc.nextInt();
//        produtoDao.deleteById(id);
//        System.out.println("Registro deletado");
//
//        System.out.println("=== Teste 3: Produto update ===");
//        Produto newproduto = new Produto();
//        newproduto = produtoDao.findById(1);
//        newproduto.setNome("Farinha");
//        newproduto.setPreco(30.00);
//        newproduto.setCategoria(categoria);
//        produtoDao.update(newproduto);
//        System.out.println("Registro atualizado");
//
//        System.out.println("=== Teste 4: Produto findbyAll ===");
//        List<Produto> list = produtoDao.findAll();
//        for(Produto produto1 : list){
//            System.out.println(produto1);
//        }
//
//        System.out.println("=== Teste 5: Produto findbyId ===");
//        Produto produto2 = produtoDao.findById(1);
//        System.out.println(produto2);


//        System.out.println("====================Pedido=========================");

//        System.out.println("=== Teste 1: pedido insert ===");
//        Pedido pedido = new Pedido(null,new Date(),200.0);
//        pedidoDao.insert(pedido);
//        System.out.println("Inserido novo Registro = " + pedido.getIdPedido());
//
//
//        System.out.println("=== Teste 2: pedido delete ===");
//        System.out.println("Entre com o ID para deletar:");
//        int id = sc.nextInt();
//        pedidoDao.deleteById(id);
//        System.out.println("Registro deletado");
//
//        System.out.println("=== Teste 3: pedido update ===");
//        Pedido pedido = new Pedido();
//        pedido = pedidoDao.findById(1);
//        pedido.setData(new Date());
//        pedido.setTotal(500.00);
//        pedidoDao.update(pedido);
//        System.out.println("Registro atualizado");
//
//        System.out.println("=== Teste 4: pedido findbyAll ===");
//        List<Pedido> list = pedidoDao.findAll();
//        for(Pedido pd : list){
//            System.out.println(pd);
//        }
//
//        System.out.println("=== Teste 5: pedido findbyId ===");
//        Pedido pedido2 = pedidoDao.findById(1);
//        System.out.println(pedido2);

//        System.out.println("====================itempedido=========================");

//        System.out.println("=== Teste 1: itempedido insert ===");
//        ItemPedido newItemPedido = new ItemPedido(null,50,pedido2,produto2);
//        itemPedidoDao.insert(newItemPedido);
//        System.out.println("Inserido novo ID = " + newItemPedido.getIdItemPedido());
//
//        System.out.println("=== Teste 2: itempedido delete ===");
//        System.out.println("Entre com o ID para deletar:");
//        int id = sc.nextInt();
//        pedidoDao.deleteById(id);
//        System.out.println("Registro deletado");
//
//        System.out.println("=== Teste 3: itempedido update ===");
//        ItemPedido itemPedido = new ItemPedido();
//        itemPedido = itemPedidoDao.findById(2);
//        itemPedido.setQuantidade(50);
//        itemPedido.setValor(80.00);
//        itemPedido.setPedido(pedido2);
//        itemPedido.setProduto(produto2);
//        itemPedidoDao.update(itemPedido);
//        System.out.println("Registro atualizado");
//
//        System.out.println("=== Teste 4: itempedido findbyAll ===");
//        List<ItemPedido> list = itemPedidoDao.findAll();
//        for(ItemPedido cx : list){
//            System.out.println(cx);
//        }
//
//          System.out.println("=== Teste 5: itempedido findbyId ===");
//          ItemPedido itemPedido1 = itemPedidoDao.findById(1);
//          System.out.println(itemPedido1);


//        System.out.println("====================Caixa=========================");
//        System.out.println("=== Teste 1: Caixa insert ===");
//        Pedido pedido = new Pedido(1,new Date(),10.00);
//        Caixa caixa = new Caixa(null,100.00,200.00,pedido);
//        caixaDao.insert(caixa);
//        System.out.println("Inserido novo Registro = " + caixa.getIdCaixa());

//        System.out.println("=== Teste 2: Caixa delete ===");
//        System.out.println("Entre com o ID para deletar:");
//        int id = sc.nextInt();
//        caixaDao.deleteById(id);
//        System.out.println("Registro deletado");

//        System.out.println("=== Teste 3: Caixa update ===");
//        Pedido pedido = new Pedido(1,new Date(),250.00);
//        pedidoDao.insert(pedido);
//        Caixa caixa = new Caixa();
//        caixa = caixaDao.findById(1);
//        caixa.setSaldo(950.00);
//        caixa.setValorPagamento(40.00);
//        caixa.setPedido(pedido);
//        caixaDao.update(caixa);
//        System.out.println("Registro atualizado");

//        System.out.println("=== Teste 4: Caixa findbyId ===");
//        Caixa caixa = caixaDao.findById(1);
//        System.out.println(caixa);


    }
}
