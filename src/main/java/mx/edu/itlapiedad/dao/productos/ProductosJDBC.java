package mx.edu.itlapiedad.dao.productos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import mx.edu.itlapiedad.models.Productos;


@Repository
public class ProductosJDBC implements ProductosDAO{

	@Autowired
	JdbcTemplate conexion;
	
	@Override
	public List<Productos> consultarProductos() {
		String sql_query="SELECT* FROM productos WHERE activo=1";
		return conexion.query(sql_query, new RowMapper<Productos>() {

			@Override
			public Productos mapRow(ResultSet rs, int rowNum) throws SQLException {
				Productos producto=new Productos();
				producto.setId(rs.getInt("id"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecio(rs.getFloat("precio"));
				producto.setCodigo_barras(rs.getString("codigo_barras"));
				producto.setExistencia(rs.getInt("existencia"));
				return producto;
			}
			
			
		});
	}

	@Override
	public Productos buscar(int id) {
		String sql_query = "SELECT * FROM productos WHERE id = ? AND activo = 1";
		return conexion.queryForObject(sql_query, new RowMapper<Productos>() {
			public Productos mapRow(ResultSet rs, int rowNum) throws SQLException{
				Productos producto = new Productos();
				producto.setId(rs.getInt("id"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecio(rs.getFloat("precio"));
				producto.setCodigo_barras(rs.getString("codigo_barras"));
				producto.setExistencia(rs.getInt("existencia"));
				return producto;
			}
		}, id);
		
	}
	
	@Override
	public Productos insertarProductos(Productos productos) {
		SimpleJdbcInsert insert=new SimpleJdbcInsert(conexion).withTableName("productos")
				.usingColumns("descripcion","precio","codigo_barras","existencia")
				.usingGeneratedKeyColumns("id");
		Map<String, Object> datos=new HashMap<>();
		datos.put("descripcion", productos.getDescripcion());
		datos.put("precio", productos.getPrecio());
		datos.put("codigo_barras", productos.getCodigo_barras());
		datos.put("existencia", productos.getExistencia());
		Number id=insert.executeAndReturnKey(datos);
		productos.setId(id.intValue());
		return productos;
	}

	@Override
	public void actualizarProductos(Productos productos) {
		String sql_update="UPDATE productos SET descripcion=?, precio=?, codigo_barras=?,"
				+ "existencia=? WHERE id=?";
		conexion.update(sql_update,productos.getDescripcion(),
				productos.getPrecio(),
				productos.getCodigo_barras(),
				productos.getExistencia(),
				productos.getId());
	}
	
	@Override
	public void eliminarProductos(int id) {
		String sql_update="UPDATE productos SET activo=0 WHERE id=?";
		conexion.update(sql_update,id);
	}
	
}












