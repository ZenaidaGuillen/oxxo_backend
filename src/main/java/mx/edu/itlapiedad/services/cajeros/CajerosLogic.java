package mx.edu.itlapiedad.services.cajeros;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.dao.cajeros.CajerosDAO;
import mx.edu.itlapiedad.models.Cajeros;

@Service
public class CajerosLogic implements CajerosService{
	@Autowired
	CajerosDAO repositorio;
	
	@Override
	public List<Cajeros> consultarCajeros() {
		// TODO Auto-generated method stub
		return repositorio.consultarCajeros();
	}

	@Override
	public Cajeros buscarCajeroporId(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscarCajeroporId(id);
	}

	@Override
	public Cajeros insertarCajeros(Cajeros cajeros) {
		// TODO Auto-generated method stub
		return repositorio.insertarCajeros(cajeros);
	}

	@Override
	public void actualizarCajeros(Cajeros cajeros) {
		// TODO Auto-generated method stub
		 repositorio.actualizarCajeros(cajeros);
	}

	@Override
	public void eliminarCajeros(int id) {
		// TODO Auto-generated method stub
		 repositorio.eliminarCajeros(id);
	}

}
