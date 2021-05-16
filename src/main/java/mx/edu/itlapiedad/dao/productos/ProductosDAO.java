package mx.edu.itlapiedad.dao.productos;

import java.util.List;


import mx.edu.itlapiedad.models.Productos;

public interface ProductosDAO {

	public List<Productos>consultarProductos();
	public Productos buscar(int id);
	public Productos insertarProductos(Productos productos);
	void actualizarProductos(Productos productos);
	void eliminarProductos(int id);
}
