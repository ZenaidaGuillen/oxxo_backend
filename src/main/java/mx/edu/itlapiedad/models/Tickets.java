package mx.edu.itlapiedad.models;

import java.sql.Timestamp;

public class Tickets {
	private int id, cajero_id;
	private float total;
	private Timestamp fecha_hora;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCajero_id() {
		return cajero_id;
	}
	public void setCajero_id(int cajero_id) {
		this.cajero_id = cajero_id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Timestamp getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(Timestamp fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	

}
