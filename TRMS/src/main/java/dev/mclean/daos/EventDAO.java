package dev.mclean.daos;

import java.util.List;

import dev.mclean.models.Event;


public interface EventDAO {
	
	public List<Event> getAllEvents();
	public Event getEvent(int ev_id);
	
	

}
