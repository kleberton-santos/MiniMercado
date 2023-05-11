package aplication;

import dao.*;
import model.*;

import java.util.List;
import java.util.Scanner;

public class MiniMercado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        CaixaDao caixaDao = DaoFactory.createCaixaDao();
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();
        CategoriaDao categoriaDao = DaoFactory.createCategoriaDao();
        PedidoDao pedidoDao = DaoFactory.createPedidoDao();
        ItemPedidoDao itemPedidoDao = DaoFactory.createItemPedidoDao();


        System.out.println("====================Pagamento=========================");

//        System.out.println("=== Teste 1: Pagamento insert ===");
//        Pagamento pagamento = new Pagamento(null,10.00);
//        pagamentoDao.insert(pagamento);
//        System.out.println("Inserido novo ID = " + pagamento.getIdPagamento());
//
//        System.out.println("=== Teste 2: Pagamento delete ===");
//        System.out.println("Entre com o ID para deletar:");
//        int id = sc.nextInt();
//        pagamentoDao.deleteById(id);
//        System.out.println("Registro deletado");
//
//        System.out.println("=== Teste 3: Pagamento update ===");
//        Pagamento pagamento1 = new Pagamento();
//        pagamento1 = pagamentoDao.findById(1);
//        pagamento1.setValor(500.00);
//        pagamentoDao.update(pagamento1);
//        System.out.println("Registro atualizado");
//
//        System.out.println("=== Teste 4: Pagamento findbyAll ===");
//        List<Pagamento> list = pagamentoDao.findAll();
//        for(Pagamento pg : list){
//            System.out.println(pg);
//        }
//
//        System.out.println("=== Teste 5: Pagamento findbyId ===");
//        Pagamento pagamento2 = pagamentoDao.findById(1);
//        System.out.println(pagamento2);

        System.out.println("====================Categoria=========================");

//        System.out.println("=== Teste 1: Categoria insert ===");
//        Categoria newCategoria = new Categoria(null,"Limpeza");
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
//        categoria = categoriaDao.findById(4);
//        categoria.setNome("Padaria");
//        categoriaDao.update(categoria);
//        System.out.println("Registro atualizado");
//
//        System.out.println("=== Teste 4: Categoria findbyAll ===");
//        List<Categoria> list = categoriaDao.findAll();
//        for(Categoria categoria : list){
//            System.out.println(categoria);
//        }
//
//        System.out.println("=== Teste 5: Categoria findbyId ===");
//        Categoria categoria = categoriaDao.findById(4);
//        System.out.println(categoria);


        System.out.println("====================Produto=========================");

//        System.out.println("=== Teste 1: Produto insert ===");
//        Produto produto = new Produto(null,"Miojo",5.00,categoria);
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
//        newproduto = produtoDao.findById(5);
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
//        Produto produto2 = produtoDao.findById(5);
//        System.out.println(produto2);


        System.out.println("====================Pedido=========================");

//        System.out.println("=== Teste 1: pedido insert ===");
//        Pedido pedido = new Pedido(null,new Date(),100.0);
//        pedidoDao.insert(pedido);
//        System.out.println("Inserido novo ID = " + pedido.getIdPedido());
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
//        pedido = pedidoDao.findById(2);
//        pedido.setData(new Date());
//        pedido.setTotal(200.00);
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
//        Pedido pedido2 = pedidoDao.findById(2);
//        System.out.println(pedido2);




        System.out.println("====================itempedido=========================");

//        System.out.println("=== Teste 1: itempedido insert ===");
//        ItemPedido newItemPedido = new ItemPedido(null,10,pedido2,produto2);
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


        System.out.println("====================Caixa=========================");

//        System.out.println("=== Teste 1: Caixa insert ===");
//        Caixa caixa = new Caixa(null,50.00,pagamento2,estoque2);
//        caixaDao.insert(caixa);
//        System.out.println("Inserted! New id = " + caixa.getIdCaixa());
//
//        System.out.println("=== Teste 2: Caixa delete ===");
//        System.out.println("Entre com o ID para deletar:");
//        int id = sc.nextInt();
//        caixaDao.deleteById(id);
//        System.out.println("Registro deletado")
//
//        System.out.println("=== Teste 3: Caixa update ===");
//        Caixa caixa1 = new Caixa();
//        caixa1 = caixaDao.findById(1);
//        caixa1.setSaldo(5.00);
//        caixa1.setPagamento(pagamento2);
//        caixa1.setEstoque(estoque2);
//        caixaDao.update(caixa);
//        System.out.println("Registro atualizado");
//
//        System.out.println("=== Teste 4: caixa findbyAll ===");
//        List<Caixa> list = caixaDao.findAll();
//        for(Caixa cx : list){
//            System.out.println(cx);
//        }
//
//        System.out.println("=== Teste 1: Caixa findbyId ===");
//        Caixa caixa2 = caixaDao.findById(1);
//        System.out.println(caixa2);

    }
}