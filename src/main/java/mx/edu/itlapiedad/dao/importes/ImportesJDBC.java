package mx.edu.itlapiedad.dao.importes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import mx.edu.itlapiedad.models.Importes;


@Repository
public class ImportesJDBC implements ImportesDAO {

	@Autowired
	JdbcTemplate conexion;
	

	@Override
	public List<Importes> consultarImportes(int id) {
		String sql_query = "SELECT  c.id, c.nombre, importe FROM ticket_renglones tr JOIN tickets t ON tr.TICKET_id = t.id INNER JOIN cajeros c ON c.id=t.CAJERO_id WHERE  c.id=?";
		return conexion.query(sql_query, new RowMapper<Importes>() {

			@Override
			public Importes mapRow(ResultSet rs, int rowNum) throws SQLException {
				Importes importes = new Importes();
				importes.setCajero_id(rs.getInt("c.id"));
				importes.setCajero_nombre(rs.getString("c.nombre"));
				importes.setImporte(rs.getFloat("importe"));
				return importes;	
			}
			
		}, id);
		
}
}
