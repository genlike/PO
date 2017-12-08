package mmt.core;

import java.time.LocalDate;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Itinerary implements java.io.Serializable, Comparable<Itinerary>{

	private LocalDate 	  _departureDate;
	private double 	  	  _cost;
	private List<Segment> _listSegmentos;

	Itinerary(){
		_listSegmentos = new ArrayList<>();
	}
	
	Itinerary(LocalDate departureDate){
		_departureDate = departureDate;
		_listSegmentos = new ArrayList<>();
	}

	
	double getTotalCost(){
		return _cost;
	}


	LocalDate getDepartureDate(){
		return _departureDate;
	}


	Duration getTotalDuration(){

		Duration duration = Duration.ZERO;

		for (Segment sg : _listSegmentos)
			duration = duration.plus(sg.getDuration());

		return duration;
	}
	
	void setDepartureDate(LocalDate ld) { _departureDate = ld; }
	
	void addSegment(Segment segment){
		_listSegmentos.add(segment);
		_cost += segment.getCost();
	}
	
	List<Segment> getSegments(){
		return Collections.unmodifiableList(_listSegmentos);
	}
	
	/*public String toString(){
		TODO
	}*/
	public int compareTo(Itinerary p){  
		return this.getTotalDuration().compareTo(p.getTotalDuration());
	}


}