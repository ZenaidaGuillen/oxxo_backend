package mx.edu.itlapiedad.dao;

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
		String sql_query="SELECT* FROM tickets";
		return conexion.query(sql_query, new RowMapper<Tickets>() {

			@Override
			public Tickets mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tickets ticket=new Tickets();
				ticket.setId(rs.getInt("id"));
				ticket.setFecha_hora(rs.getTimestamp("fecha_hora"));
				ticket.setTotal(rs.getFloat("total"));
				ticket.setCajero_id(rs.getInt("cajero_id"));
				
				return ticket;
			}
			
			
		});
	}

	@Override
	public Tickets buscar(int id) {
		String sql_query = "SELECT * FROM tickets WHERE id = ?";
		return conexion.queryForObject(sql_query, new RowMapper<Tickets>() {
			public Tickets mapRow(ResultSet rs, int rowNum) throws SQLException{
				Tickets ticket = new Tickets();
				ticket.setId(rs.getInt("id"));
				ticket.setFecha_hora(rs.getTimestamp("fecha_hora"));
				ticket.setTotal(rs.getFloat("total"));
				ticket.setCajero_id(rs.getInt("cajero_id"));
			
				return ticket;
			}
		}, id);
		
	}
	
	@Override
	public Tickets insertarTickets(Tickets tickets) {
		SimpleJdbcInsert insert=new SimpleJdbcInsert(conexion).withTableName("tickets")
				.usingColumns("total","CAJERO_id")
				.usingGeneratedKeyColumns("id");
		Map<String, Object> datos=new HashMap<>();
		//datos.put("fecha_hora", tickets.getFecha_hora());
		datos.put("total", tickets.getTotal());
		datos.put("CAJERO_id", tickets.getCajero_id());
		Number id=insert.executeAndReturnKey(datos);
		tickets.setId(id.intValue());
		return tickets;
	}


}

