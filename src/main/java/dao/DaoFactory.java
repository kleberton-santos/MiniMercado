package dao;

import Service.*;
import db.DB;


public class DaoFactory {
    public static CategoriaDao createCategoriaDao(){ return new CategoriaServiceDaoJDBC(DB.getConnection());}
    public static PedidoDao createPedidoDao(){ return new PedidoServiceDaoJDBC(DB.getConnection());}
    public static ProdutoDao createProdutoDao(){ return new ProdutoServiceDaoJDBC(DB.getConnection());}
    public static ItemPedidoDao createItemPedidoDao(){ return new ItemPedidoServiceDaoJDBC(DB.getConnection());}
    public static CaixaDao createCaixaDao(){ return new CaixaServiceDaoJDBC(DB.getConnection());}

}
