
package dao;


import domain.Marca;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MarcaDao extends JpaRepository<Marca,Long> {
    
}
