package mx.edu.itlapiedad.dao.tickets;

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

import mx.edu.itlapiedad.models.Tickets;


@Repository
public class TicketsJDBC implements TicketsDAO {

	@Autowired
	JdbcTemplate conexion;
	
	@Override
	public List<Tickets> consultarTickets() {
		String sql_query="SELECT* FROM tickets WHERE activo=1";
		return conexion.query(sql_query, new RowMapper<Tickets>() {

			@Override
			public Tickets mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tickets ticket=new Tickets();
				ticket.setId(rs.getInt("id"));
				ticket.setFecha_hora(rs.getTimestamp("fecha_hora"));
				ticket.setTotal(rs.getFloat("total"));
				ticket.setCajero_id(rs.getInt("cajero_id"));
				// ticket.setActivo(rs.getInt("activo"));
				
				return ticket;
			}
			
			
		});
	}

	@Override
	public Tickets buscar(int id) {
		String sql_query = "SELECT * FROM tickets WHERE id = ? AND activo = 1";
		return conexion.queryForObject(sql_query, new RowMapper<Tickets>() {
			public Tickets mapRow(ResultSet rs, int rowNum) throws SQLException{
				Tickets ticket = new Tickets();
				ticket.setId(rs.getInt("id"));
				ticket.setFecha_hora(rs.getTimestamp("fecha_hora"));
				ticket.setTotal(rs.getFloat("total"));
				ticket.setCajero_id(rs.getInt("cajero_id"));
				// ticket.setActivo(rs.getInt("activo"));
				return ticket;
			}
		}, id);
		
	}
	
	@Override
	public Tickets insertarTickets(Tickets tickets) {
		SimpleJdbcInsert insert=new SimpleJdbcInsert(conexion).withTableName("tickets")
				.usingColumns("total","cajero_id")
				.usingGeneratedKeyColumns("id");
		Map<String, Object> datos=new HashMap<>();
		//datos.put("fecha_hora", tickets.getFecha_hora());
		datos.put("total", tickets.getTotal());
		datos.put("cajero_id", tickets.getCajero_id());
		Number id=insert.executeAndReturnKey(datos);
		tickets.setId(id.intValue());
		// tickets.setActivo(1);
		return tickets;
	}

	@Override
	public void eliminarTickets(int id) {
		String sql_update="UPDATE tickets SET activo=0 WHERE id = ?";
		conexion.update(sql_update, id);
		
	}
	
	@Override
	public void actualizarTickets(Tickets tickets) {
		String sql_update="UPDATE tickets SET total = ?, cajero_id = ?  WHERE id = ?";
		conexion.update(sql_update, tickets.getTotal(), tickets.getCajero_id(), tickets.getId());
		
	}
}

