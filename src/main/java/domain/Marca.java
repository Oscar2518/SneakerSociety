
package domain;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="marca")
public class Marca implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_marca")
    private Long idMarca;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
   @OneToMany
   @JoinColumn(name="id_marca", updatable= false)
   private List<Producto> productos;
    
}

