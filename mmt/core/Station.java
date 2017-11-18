package mmt.core;

import java.util.List;
import java.util.ArrayList;

public class Station implements java.io.Serializable {
	private String _description;
	private List<Stop> listaStops;

	Station(String description){
		setDescription(description);
		listaStops = new ArrayList<>();
	}
	
	String getDescription(){
		return _description;
	}
	
	void setDescription(String description){
		_description = description;		
	}
	
	void addStop(Stop a){
		listaStops.add(a);
	}
	
	List<Stop> getStops(){
		return listaStops;
	}
	public String toString() {
		return _description;
	}
}