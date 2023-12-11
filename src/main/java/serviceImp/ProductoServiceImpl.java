
package serviceImp;


import dao.ProductoDao;
import domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private ProductoDao productoDao;
    

    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activo) {
       var productos=productoDao.findAll();
       if(activo){
           //Eliminaria de la lista las productos...iniciativas
           productos.removeIf(e -> !e.isActivo());
       }
       return productos;
    }

    @Override
    @Transactional(readOnly=true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }


    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }
    
    //Una Consulta tipo Query
    @Transactional(readOnly=true)
    @Override
    public List<Producto> consultaQuery(double precioInf, double precioSup){
    return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
}
