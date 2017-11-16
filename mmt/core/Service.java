package mmt.core;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class Service{
	
	private final int _idService;
	private double _totalCost;
	
	private Duration _totalDuration;

	private List<Stop> listaStops;

	public Service (int idService,double totalCost) {
		_idService = idService;
		_totalCost = totalCost;
		listaStops = new ArrayList<>();		
	}
	

	Duration getDuration(Stop startStop, Stop finalStop){
		return Duration.between(startStop.getSchedule,finalStop.getSchedule);
	}
	
	double getCost(Stop startStop, Stop finalStop){			
		return (getDuration(startStop, finalStop).toMinutes)*_totalCost)/_totalDuration.toMinutes; 
	}