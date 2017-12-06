package mmt.core;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;



public class Itinerary implements java.io.Serializable{

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
			duration.plus(sg.getDuration());

		return duration;
	}
	
	void setDepartureDate(LocalDate ld) { _departureDate = ld; }
	
	void addSegment(Segment segment){
		_listSegmentos.add(segment);
		_cost += segment.getCost();
	}
	
	List<Segment> getSegments(){
		return Collection.unmodifiableList(_listSegmentos);
	}
	
	void extendItinerary(Itinerary it) {
		this._listSegmentos.addAll(it._listSegmentos);
	}
	/*public String toString(){
		TODO
	}*/

}