package mmt.core;

import java.util.List;
import java.util.ArrayList;

public class Station implements java.io.Serializable {
	private String _description;
	private List<Stop> listaStops;

	public Station(String description){
		setDescription(description);
		listaStops = new ArrayList<>();
	}
	
	public String getDescription(){
		return _description;
	}
	
	public void setDescription(String description){
		_description = description;		
	}
	
	public void addStop(Stop a){
		listaStops.add(a);
	}
	
	public List<Stop> getStops(){
		return listaStops;
	}
}