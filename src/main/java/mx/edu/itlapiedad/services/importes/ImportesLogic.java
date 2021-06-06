package mx.edu.itlapiedad.services.importes;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.dao.importes.ImportesDAO;

import mx.edu.itlapiedad.models.Importes;

@Service
public class ImportesLogic implements ImportesService{

	@Autowired
	ImportesDAO repositorio;

	@Override
	public List<Importes> consultarImportes(int id, Timestamp fecha_horai, Timestamp fecha_horaf) {
		// TODO Auto-generated method stub
		return repositorio.consultarImportes(id, fecha_horai, fecha_horaf);
	}
	

}
