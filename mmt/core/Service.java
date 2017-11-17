package mmt.core;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Service  implements java.io.Serializable {
	
	private final int _idService;
	private double _totalCost;
	
	private Duration _totalDuration;

	private List<Stop> _listaStops;

	public Service (int idService,double totalCost) {
		_idService = idService;
		_totalCost = totalCost;
		_listaStops = new ArrayList<>();		
	}
	

	public Duration getDuration(Stop startStop, Stop finalStop){
		return Duration.between(startStop.getSchedule(),finalStop.getSchedule());
	}
	
	public double getCost(Stop startStop, Stop finalStop){			
		return ((getDuration(startStop, finalStop).toMinutes())*_totalCost)/_totalDuration.toMinutes();
	}

	public List<Stop> getStops() {
		return _listaStops;
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("###.##");
		return "Serviço #"+_idService+" @ "+ df.format(_totalCost);
	}
	
	void addStop(Station stationStop, LocalTime arrivalDate){
		Stop a = new Stop(stationStop, arrivalDate);
		a.setService(this);
		stationStop.addStop(a);
		_listaStops.add(a);
	}		
}