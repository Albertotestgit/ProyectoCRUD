
/**
 * Write a description of class ModeloHaspMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package gestionalmacen01.modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ModeloHashMap implements ModeloAbs
{
    private HashMap <Integer,Producto> mapa;
    
    public ModeloHashMap()
    {
       mapa=new HashMap  <Integer,Producto>();
    }

    public boolean insertarProducto ( Producto p){
      assert ( p != null ); // No permito productos nulos  
      mapa.put(p.getCodigo(),p);
      return true;
    }
 
    public boolean borrarProducto ( int codigo ){
      // Si es null es que no estaba
      return ( mapa.remove(codigo) != null);
    }
    
    public Producto buscarProducto ( int codigo) {
        return mapa.get(codigo);
    }
    // Funciona pero no es una solución independiente del la mécanismo de salida.
    // El acceso a datos debe ser independiente de la visualización de los mismos.
    public void listarProductosTodos (){
        int i = 1;
        for (Producto p: mapa.values()) {
            System.out.println(" Nº "+i+" "+p);
            i++;
        }
        
        //mapa.values().forEach(p-> System.out.println(p));
    }

    // Devuelvo una lista con los productos con stock mínimo
    // Será el programa principal quien se encargue de mostrarlos
	public List<Producto> listarProductosStockMin() {
	    List <Producto> resu1 = new ArrayList<Producto>();
	    for (Producto p: mapa.values()) {
	    	if ( p.getStock() <= p.getStock_min()) {
				resu1.add(p);
			}
        }
	 // Otra forma: Crea una nueva lista a partir de los valores y borro los que supera el stock mínimo
	 List <Producto> resu2 = new ArrayList<Producto>(mapa.values());
	 // Elimino los que superan el mínimo
	 resu2.removeIf(p -> (p.getStock() > p.getStock_min()));
	 
	 return resu1;
	}

	// Solo chequea si el producto ya existia en el almacen.
    // No tiene que hacer nada pues se ha cambiado la referencia
	public boolean modificarProducto(Producto pro) {
		return mapa.containsValue(pro);
	}

	@Override
	public List<Producto> obtenerTodos() {
		// TODO Auto-generated method stub
		return new ArrayList<Producto>(mapa.values());
	}
    
    
    
}
