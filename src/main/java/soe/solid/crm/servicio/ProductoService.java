package soe.solid.crm.servicio;

import soe.solid.crm.modelo.Producto;

import java.util.List;

public interface  ProductoService {
    void registrarProducto(Producto producto);
    Producto obtenerProductoPorSku(String sku);
    List<Producto> listarProductos();
}
