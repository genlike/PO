package mmt.core;

import java.time.LocalTime;
import java.util.List;
public class Stop implements java.io.Serializable {
/**
	* Classe que representa um Servico, que é composto por uma agregacao de Paragens
	* @author Ines Albano	 87664
	* @author Ricardo Silva  87700
	* @version 1.0
*/	
/**
	* Hora que dado servico alcanca esta estacao
*/
	private LocalTime _schedule;
/**
	* Estacao a que esta associada esta paragem
*/
	private Station _station;
/**
	* Servico a que esta associado esta paragem
*/
	private Service _service;

/**
	* Construtor da paragem, assumido que está a ser chamado pelo serviço
	* forma a ter o campo _service preenchido.
	* @param station Estacao a que este stop estara relacionado
	* @param schedule Sera a hora a que o servico chega a estacao
*/
	Stop(Station station, LocalTime schedule){
		_station = station;
		_station.addStop(this);
		setSchedule(schedule);
	}

/**
	* Funcao para alterar a hora da paragem
*/
	void setSchedule(LocalTime schedule){
		_schedule = schedule;
	}

/**
	* Funcao para alterar o servico.
*/
	void setService(Service service){
		_service = service;
	}

/**
	* Funcao que retorna uma copia da hora de paragem
*/	
	LocalTime getSchedule() { return _schedule.plusHours(0); }

/**
	* Funcao que retorna o servico associado
*/	
	Service getService(){ return _service; }

/**
	* Funcao que retorna a estacao associada
*/	
	Station getStation(){ return _station; }

/**
	* Impressao formatada da paragem
	* @see mmt.core.Service#toString()
*/
	public String toString() {
	  return String.format("%02d:%02d %s", getSchedule().getHour(),getSchedule().getMinute(),getStation());
	}

/**
	 * Funcao que retorna se um dado Stop igual ao actual,
	 * 2 Stops sao iguais, quando o seu Servico, Station e horario igual,
	 * @param o objecto em questao a ser testado
*/
	public boolean equals(Object o) {
		if (o instanceof Stop) {
			Stop st = (Stop)o;
			return st.getService().equals(this.getService()) 
					&& st.getStation().equals(this.getStation())
					&& st.getSchedule().equals(this.getSchedule());
		} else {
			return false;
		}
	}


	Stop getNext() {
		List<Stop> stps = getService().getStops();
		int i = stps.indexOf(this)+1;
		if (i>(stps.size()-1)) 
			return null;
		return stps.get(i);
	}
}