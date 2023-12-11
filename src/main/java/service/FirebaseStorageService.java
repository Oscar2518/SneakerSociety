
package service;
import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    
    final String BucketName = "sneakersociety-dec47.appspot.com";

   
    final String rutaSuperiorStorage = "SneakerSociety";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "";
    
}

