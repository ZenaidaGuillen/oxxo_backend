package mx.edu.itlapiedad.services;

import java.util.List;

import mx.edu.itlapiedad.models.Tickets;

public interface TicketService {
	
	List<Tickets> consultarTickets();
	Tickets buscar(int id);
	Tickets insertarTickets(Tickets tickets);

}
