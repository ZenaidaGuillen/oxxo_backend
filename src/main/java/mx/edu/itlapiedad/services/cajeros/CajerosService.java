package mx.edu.itlapiedad.services.cajeros;

import java.util.List;

import mx.edu.itlapiedad.models.Cajeros;

public interface CajerosService {

	List<Cajeros> consultarCajeros();
	Cajeros buscarCajeroporId(int id);
	Cajeros insertarCajeros(Cajeros cajeros);
	void actualizarCajeros(Cajeros cajeros);
	void eliminarCajeros(int id);

}
