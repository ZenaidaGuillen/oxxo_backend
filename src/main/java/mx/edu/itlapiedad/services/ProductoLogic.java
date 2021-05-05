package mx.edu.itlapiedad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.dao.ProductosDAO;
import mx.edu.itlapiedad.models.Productos;

@Service
public class ProductoLogic implements ProductoService {

	@Autowired
	ProductosDAO repositorio;
	
	@Override
	public List<Productos> consultarProductos() {
		return repositorio.consultarProductos();
	}

	@Override
	public Productos buscar(int id) {
		return repositorio.buscar(id);
	}
	public Productos insertarProductos(Productos productos) {
		return repositorio.insertarProductos(productos);
	}

}
