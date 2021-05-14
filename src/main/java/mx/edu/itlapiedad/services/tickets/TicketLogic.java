package mx.edu.itlapiedad.services.tickets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.dao.tickets.TicketsDAO;
import mx.edu.itlapiedad.models.Tickets;


@Service
public class TicketLogic implements TicketService {


	@Autowired
	TicketsDAO repositorio;
	
	@Override
	public List<Tickets> consultarTickets() {
		return repositorio.consultarTickets();
	}

	@Override
	public Tickets buscar(int id) {
		return repositorio.buscar(id);
	}
	public Tickets insertarTickets(Tickets tickets) {
		return repositorio.insertarTickets(tickets);
	}

	@Override
	public void eliminarTickets(int id) {
		// TODO Auto-generated method stub
		repositorio.eliminarTickets(id);
		
	}

	@Override
	public void actualizarTickets(Tickets tickets) {
		// TODO Auto-generated method stub
		repositorio.actualizarTickets(tickets);
	}
}
