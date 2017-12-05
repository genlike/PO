package mmt.core;

public class Itinerary implements java.io.Serializable{

	private LocalDate 	  _departureDate;
	private double 	  	  _cost;
	private List<Segment> _listSegmentos;


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


	void addSegment(Segment segment){
		_listSegmentos.add(segment);
		_cost += segment.getCost();
	}


	/*public String toString(){
		TODO
	}*/

}