
package controller;

import domain.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import serviceImp.FirebaseStorageServiceImpl;
import service.MarcaService;

@Controller
@RequestMapping("/marca")
public class MarcaController {
    
    
    @Autowired
    private MarcaService marcaService;
    
    @GetMapping("/listado")
    public String listado(Model model){
       model.addAttribute("atributo", "Saludos a todos");
       var marcas = marcaService.getMarca(false);
       model.addAttribute("marcas", marcas);
       model.addAttribute("totalMarcass", marcas.size());
       return "/marca/listado";
    }
     @GetMapping("/nuevo")
    public String marcaNuevo(Marca marca) {
        return "/marca/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String marcaGuardar(Marca marca,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            marcaService.save(marca);
            marca.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "marca", 
                            marca.getIdMarca()));
        }
        marcaService.save(marca);
        return "redirect:/marca/listado";
    }

    @GetMapping("/eliminar/{idMarca}")
    public String marcaEliminar(Marca marca) {
        marcaService.delete(marca);
        return "redirect:/marca/listado";
    }

    @GetMapping("/modificar/{idMarca}")
    public String marcaModificar(Marca marca, Model model) {
        marca = marcaService.getMarca(marca);
        model.addAttribute("marca", marca);
        return "/marca/modifica";
    }
}

