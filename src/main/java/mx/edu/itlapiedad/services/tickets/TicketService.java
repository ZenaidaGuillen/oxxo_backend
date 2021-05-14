package mx.edu.itlapiedad.services.tickets;

import java.util.List;

import mx.edu.itlapiedad.models.Tickets;

public interface TicketService {
	
	List<Tickets> consultarTickets();
	Tickets buscar(int id);
	Tickets insertarTickets(Tickets tickets);
	void eliminarTickets(int id);
	void actualizarTickets(Tickets tickets);

}
