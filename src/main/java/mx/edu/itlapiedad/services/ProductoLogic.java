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
		// TODO Auto-generated method stub
		return repositorio.consultarProductos();
	}

}
