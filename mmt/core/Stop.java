package mmt.core;

import java.time.LocalTime;

public class Stop implements java.io.Serializable {
	private LocalTime _schedule;
	private Station _station;
	private Service _service;

	Stop(Station station, LocalTime schedule){
		_station = station;
		_station.addStop(this);
		setSchedule(schedule);
	}
	
	
	
	void setSchedule(LocalTime schedule){
		_schedule = schedule;
	}
	
	void setService(Service service){
		_service = service;
	}
	
	LocalTime getSchedule() { return _schedule; }
	Service getService(){ return _service; }
	Station getStation(){ return _station; }

	public toString() {
	  return String.format("{0:HH:mm} %s", getSchedule(), getStation());
	}
}