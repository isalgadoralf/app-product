package soe.solid.crm.datos;

import soe.solid.crm.modelo.Producto;

import java.util.List;

public interface  ProductoRepository {
    void guardar(Producto producto);
    Producto buscarPorSku(String sku);
    List<Producto> buscarTodos();
}
