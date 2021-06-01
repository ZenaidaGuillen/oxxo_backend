package mx.edu.itlapiedad.dao.renglones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import mx.edu.itlapiedad.models.Renglones;

@Repository
public class RenglonesJDBC implements RenglonesDAO {
	
	@Autowired
	JdbcTemplate conexion;

	@Override
	public List<Renglones> consultarRenglones() {
		String sql_query = "SELECT * FROM ticket_renglones WHERE activo = 1";
		return conexion.query(sql_query, new RowMapper<Renglones>() {

			@Override
			public Renglones mapRow(ResultSet rs, int rowNum) throws SQLException {
				Renglones renglones = new Renglones();
				renglones.setId(rs.getInt("id"));
				renglones.setCantidad(rs.getInt("cantidad"));
				renglones.setPrecio(rs.getFloat("precio"));
				renglones.setImporte(rs.getFloat("importe"));
				renglones.setTicket_id(rs.getInt("TICKET_id"));
				renglones.setProducto_id(rs.getInt("PRODUCTO_id"));
				
				return renglones;
			}
			
		});
		
	}

	@Override
	public Renglones buscar(int id) {
		String sql_query = "SELECT * FROM ticket_renglones WHERE id = ? AND activo = 1";
		return conexion.queryForObject(sql_query, new RowMapper<Renglones>() {

			@Override
			public Renglones mapRow(ResultSet rs, int rowNum) throws SQLException {
				Renglones renglon = new Renglones();
				
				if(rs.getInt("activo") == 1){
					
					renglon.setId(rs.getInt("id"));
					renglon.setCantidad(rs.getInt("cantidad"));
					renglon.setPrecio(rs.getFloat("precio"));
					renglon.setImporte(rs.getFloat("importe"));
					renglon.setTicket_id(rs.getInt("TICKET_id"));
					renglon.setProducto_id(rs.getInt("PRODUCTO_id"));
					return renglon;
					
				} else {
					
					return renglon;
				}										
				
			}
			
		}, id);
	}

	@Override
	public Renglones insertarRenglones(Renglones renglones) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(conexion).withTableName("ticket_renglones")
				.usingColumns("TICKET_id","PRODUCTO_id","cantidad","precio")
				.usingGeneratedKeyColumns("id");
		Map<String, Object> datos = new HashMap<>();
		datos.put("TICKET_id", renglones.getTicket_id());
		datos.put("PRODUCTO_id", renglones.getProducto_id());
		datos.put("cantidad", renglones.getCantidad());
		datos.put("precio", renglones.getPrecio());
		
		Number id = insert.executeAndReturnKey(datos);
		renglones.setId(id.intValue());
		
		return renglones;
	}

	@Override
	public void eliminarRenglones(int id) {
		String sql_update = "UPDATE ticket_renglones SET activo = 0 WHERE id = ?";
		conexion.update(sql_update, id);
		
	}

	@Override
	public void actualizarRenglones(Renglones renglones) {
		String sql_update = "UPDATE ticket_renglones SET TICKET_id = ?, PRODUCTO_id = ?, cantidad = ?, precio = ? WHERE id = ?";
		conexion.update(sql_update, renglones.getTicket_id(), renglones.getProducto_id(), renglones.getCantidad(), renglones.getPrecio(), renglones.getId());
		
	}

}
