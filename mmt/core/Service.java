package mmt.core;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

public class Service  implements java.io.Serializable, Comparable<Service> {
	
	private final int 	_idService;
	private double		_totalCost;
	private Duration 	_totalDuration;
	private List<Stop> 	_listStops;

	Service (int idService,double totalCost) {
		_idService = idService;
		_totalCost = totalCost;
		_listStops = new ArrayList<>();		
	}
	

	Duration getDuration(Stop startStop, Stop finalStop){
		return Duration.between(startStop.getSchedule(),finalStop.getSchedule());
	}
	
	double getCost(Stop startStop, Stop finalStop){			
		return ((getDuration(startStop, finalStop).toMinutes())*_totalCost)/_totalDuration.toMinutes();
	}

	int getId(){
		return _idService;
	}
	List<Stop> getStops() {
		return _listStops;
		
	}

	double getTotalCost() { return _totalCost; }
	int getidService() { return _idService; }

	public String toString() {
	  String s = String.format(Locale.US,"Serviço #%d @ %.2f\n",
		getidService(), getTotalCost());
	  for (Stop st: _listStops) {
	    s = s + st + "\n";
	  }
	  return s.substring(0,s.length() -1);
	}
	
	void addStop(Station stationStop, LocalTime arrivalDate){
		Stop a = new Stop(stationStop, arrivalDate);
		a.setService(this);
		_listStops.add(a);
	}

        boolean isDeparture(Stop stp) {
	  return getStops().indexOf(stp) == 0;
	}

	public int compareTo(Service s){
    	return this.getId() - s.getId();
  }
		
}