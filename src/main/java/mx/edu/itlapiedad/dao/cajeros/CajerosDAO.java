package mx.edu.itlapiedad.dao.cajeros;

import java.util.List;

import mx.edu.itlapiedad.models.Cajeros;

public interface CajerosDAO {

	List<Cajeros> consultarCajeros();
	Cajeros buscarCajeroporId(int id);
	Cajeros insertarCajeros(Cajeros cajeros);
	void actualizarCajeros(Cajeros cajeros);
	void eliminarCajeros(int id);
	


}
