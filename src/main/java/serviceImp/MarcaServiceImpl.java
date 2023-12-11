
package serviceImp;

import domain.Marca;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.MarcaDao;
import service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService {
    
    @Autowired
    private MarcaDao MarcaDao;
    

    @Override
    @Transactional(readOnly=true)
    public List<Marca> getMarca(boolean activo) {
       var marcas=MarcaDao.findAll();
       if(activo){
           marcas.removeIf(e -> !e.isActivo());
       }
       return marcas;
    }

    @Override
    @Transactional(readOnly=true)
    public Marca getMarca(Marca marca) {
        return MarcaDao.findById(marca.getIdMarca()).orElse(null);
    }


    @Override
    @Transactional
    public void delete(Marca marca) {
        MarcaDao.delete(marca);
    }

    @Override
    @Transactional
    public void save(Marca marca) {
        MarcaDao.save(marca);
    }

 
    
}

