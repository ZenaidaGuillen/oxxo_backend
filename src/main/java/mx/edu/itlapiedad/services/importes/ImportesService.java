package mx.edu.itlapiedad.services.importes;




import java.sql.Timestamp;
import java.util.List;

import mx.edu.itlapiedad.models.Importes;



public interface ImportesService {


	List<Importes> consultarImportes(int id, Timestamp fechar_horai, Timestamp fecha_horaf);
}
