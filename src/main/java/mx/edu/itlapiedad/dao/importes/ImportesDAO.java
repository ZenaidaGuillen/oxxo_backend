package mx.edu.itlapiedad.dao.importes;
import java.sql.Timestamp;
import java.util.List;

import mx.edu.itlapiedad.models.Importes;

public interface ImportesDAO  {

	

	List<Importes> consultarImportes(int id, Timestamp fecha_horai, Timestamp fecha_horaf);

}
