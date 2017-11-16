package mmt.core;

import java.time.LocalTime;

public class Stop {
	private LocalTime _schedule;
	private Station _station;
	private Service _service;

	public Stop(Station station, LocalTime schedule){
		_station = station;
		_station.addStop(this);
		 setSchedule(schedule);
	}
	
	public LocalTime getSchedule() {
		return _schedule;
	}
	
	public void setSchedule(LocalTime schedule){
		_schedule = schedule;
	}
	
	public void setService(Service service){
		_service = service;
	}
	
	public Service getService(){
		return _service;
	}
}