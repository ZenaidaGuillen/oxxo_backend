package mx.edu.itlapiedad.services.importes;

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
	public List<Importes> consultarImporte(int id) {
		// TODO Auto-generated method stub
		return repositorio.consultarImporte(id);
	}
	

}
