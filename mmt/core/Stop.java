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
	
	LocalTime getSchedule() {
		return _schedule;
	}
	
	void setSchedule(LocalTime schedule){
		_schedule = schedule;
	}
	
	void setService(Service service){
		_service = service;
	}
	
	Service getService(){
		return _service;
	}
}