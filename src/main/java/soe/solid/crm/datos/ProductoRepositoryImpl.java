package soe.solid.crm.datos;

import soe.solid.crm.modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoRepositoryImpl implements  ProductoRepository {
    private List<Producto> productos = new ArrayList<>();
    @Override
    public void guardar(Producto producto) {
        System.out.println("Guardando producto: " + producto);
        productos.add(producto);
    }

    @Override
    public Producto buscarPorSku(String sku) {
        System.out.println("Buscando producto por SKU: " + sku);
        Optional<Producto> producto = productos.stream()
                .filter(p -> p.getCSku().equals(sku))
                .findFirst();
        return producto.orElse(null);  // Retorna null si no encuentra el producto
    }

    @Override
    public List<Producto> buscarTodos() {
        System.out.println("Buscando todos los productos");
        return new ArrayList<>(productos);
    }
}
