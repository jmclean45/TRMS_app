package dev.mclean.service;

import java.util.List;

import dev.mclean.daos.EventDAO;
import dev.mclean.daos.EventDAOImpl;
import dev.mclean.models.Event;

public class EventService {
	
	public static EventDAO evd = new EventDAOImpl();
	
	public static List<Event> getAllEvents(){
		return evd.getAllEvents();
	}
	public static Event getEvent(int ev_id) {
		return evd.getEvent(ev_id);
	}
	
///////////////////////////might need to add update event
}
