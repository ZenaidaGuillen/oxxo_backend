package mx.edu.itlapiedad.dao;

import java.util.List;

import mx.edu.itlapiedad.models.Tickets;


public interface TicketsDAO {
	
	public List<Tickets>consultarTickets();
	public Tickets buscar(int id);
	public Tickets insertarTickets(Tickets tickets);
	void eliminarTickets(int id);
	void actualizarTickets(Tickets tickets);

}
