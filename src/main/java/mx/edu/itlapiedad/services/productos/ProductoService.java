package mx.edu.itlapiedad.services.productos;

import java.util.List;

import mx.edu.itlapiedad.models.Productos;

public interface ProductoService {

	List<Productos> consultarProductos();
	Productos buscar(int id);
	Productos insertarProductos(Productos productos);
	void actualizarProductos(Productos productos);
	void eliminarProductos(int id);

}
