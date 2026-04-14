package gestionalmacen01.modelo;
import java.util.List;

/**
 * Abstract class ModeloAbs - Clase de acceso a Modelo de DATOS
 * 
 * @author: Alberto Lopez
 * Date: 24/04/2018
 */
public interface  ModeloAbs
{
    
    public boolean insertarProducto ( Producto p);
    
    boolean borrarProducto ( int codigo );
    
    public Producto buscarProducto ( int codigo);
    
    void listarProductosTodos ();
    
    List <Producto> listarProductosStockMin();
    
    boolean modificarProducto (Producto nuevo);
    
    List<Producto> obtenerTodos(); 
    
    
}
