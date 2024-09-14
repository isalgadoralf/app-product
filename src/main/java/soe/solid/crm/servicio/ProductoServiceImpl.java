package soe.solid.crm.servicio;

import soe.solid.crm.datos.ProductoRepository;
import soe.solid.crm.datos.ProductoRepositoryImpl;
import soe.solid.crm.modelo.Producto;

import java.util.List;

public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void registrarProducto(Producto producto) {
        productoRepository.guardar(producto);
    }

    @Override
    public Producto obtenerProductoPorSku(String sku) {
        return productoRepository.buscarPorSku(sku);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.buscarTodos();
    }
}
