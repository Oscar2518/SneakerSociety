
package service;

import domain.Marca;
import java.util.List;


public interface MarcaService {
    //Se define la firma del metodo para obtener los registros de la tabla categoria
    
    public List<Marca> getMarca(boolean activo);
    
    //Se recupera un objeto tipo categoria que corresponde al registro de la categoria que tiene el mismo idCategoria
    public Marca getMarca(Marca marca);
    
    //Se elimina el registro que tiene idCategoria pasado por parametro
     public void delete(Marca marca);
     
     //Si hay un registro en la tabla categorias que tiene idCategorias
     //ese registro se actualiza, si no existe, o el idCategoria es nulo
     //se crea un nuevo registro en la tabla categoria
      public void save(Marca marca);
      
}
