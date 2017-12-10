package mmt.core;

import java.time.LocalDate;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

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

		Segment s1 = _listSegmentos.get(0);
		Segment s2 = _listSegmentos.get(_listSegmentos.size()-1);

		Duration duration = Duration.between(s1.getDepartureTime(),s2.getArrivalTime());

		return duration;
	}
	

	void setDepartureDate(LocalDate ld) { _departureDate = ld; }
	

	void addSegment(Segment segment){
		_listSegmentos.add(segment);
		_cost += segment.getCost();
	}
	

	void addSegmentFirst(Segment segment){
		_listSegmentos.add(0,segment);
		_cost += segment.getCost();
	}


	List<Segment> getSegments(){
		return Collections.unmodifiableList(_listSegmentos);
	}
	

	public String toString(int id){
		String s = "Itinerário " + id + " para " + _departureDate + " @ " + String.format(Locale.US, "%.2f\n", getTotalCost());
		for (Segment sg : getSegments()) {
			s+= sg.toString() +"\n";
		}
		
		return s;
	}


	public int compareTo(Itinerary p) {
		int departureDate = this.getDepartureDate().compareTo(p.getDepartureDate());
		if (departureDate == 0){
			Segment departure1 = this._listSegmentos.get(0);
			Segment departure2 = p._listSegmentos.get(0);
			int timeArrival = departure1.getDepartureTime().compareTo(departure2.getDepartureTime());
			if (timeArrival == 0) { 
				Segment arrival1 = this._listSegmentos.get(this._listSegmentos.size()-1);
				Segment arrival2 = p._listSegmentos.get(p._listSegmentos.size()-1);
				return arrival1.getDepartureTime().compareTo(arrival2.getDepartureTime());
			}
			return timeArrival;
		}
		return departureDate;	
	}


}