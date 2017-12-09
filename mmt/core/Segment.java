package mmt.core;

import java.time.Duration;
import java.time.LocalTime;


public class Segment{

	private Stop _origin;
	private Stop _destiny;


	Segment(Stop origin, Stop destiny){
		_origin  = origin;
		_destiny = destiny;
	}

	LocalTime getDepartureTime(){
		return _origin.getSchedule();
	}

	LocalTime getArrivalTime(){
		return _destiny.getSchedule();
	}

	double getCost(){
		Service s = _origin.getService();
		return s.getCost(_origin, _destiny);
	}

	Duration getDuration(){
		Service s = _origin.getService();
		return s.getDuration(_origin, _destiny); 
	}
	public String toString() {
		
		return _origin.getService().toStringSubset(_origin,_destiny);
	}

	//TODO toString que chama o toString do Service
}
