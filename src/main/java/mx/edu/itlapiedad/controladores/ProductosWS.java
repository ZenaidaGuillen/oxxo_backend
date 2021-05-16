package mx.edu.itlapiedad.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.edu.itlapiedad.models.Productos;
import mx.edu.itlapiedad.services.productos.ProductoService;



@RestController
@RequestMapping("/api/devops/oxxo")
public class ProductosWS {

	@Autowired
	ProductoService servicio;	
		
	@GetMapping("/productos")
	public ResponseEntity<?> consultarProductos() {
		List<Productos>resultado;
		try {
			resultado= servicio.consultarProductos();
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Productos>>(resultado, HttpStatus.OK);
		
	}

	@GetMapping("/productos/{id}")
	public ResponseEntity<?> buscar(@PathVariable int id){
		Productos resultado;
		try {
			resultado = servicio.buscar(id);
			
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Productos>(resultado,HttpStatus.OK);
	}


	@PostMapping()
	public ResponseEntity<?>insertarProductos(@RequestBody Productos productos){
		Productos resultado=null;
		try {
			resultado=servicio.insertarProductos(productos);
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Productos>(resultado,HttpStatus.CREATED);
		
	}
	
	@PutMapping()
	public ResponseEntity<?>actualizarProductos(@RequestBody Productos productos){
		try {
			servicio.actualizarProductos(productos);
		}catch(DataAccessException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
			
		}
		
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<?>eliminarProductos(@PathVariable int id){
		
		//se realiza esto para evaluar cuando un id no se encuentra en la base 
		// de datos.
		try {
			servicio.eliminarProductos(id);
		}catch(DataAccessException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Productos>(HttpStatus.OK);
		
	}

}
