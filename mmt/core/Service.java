package mmt.core;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Collections;
public class Service  implements java.io.Serializable, Comparable<Service> {

/**
	* Classe que representa um Servico, que é composto por uma agregacao de Paragens
	* @author Ines Albano	 87664
	* @author Ricardo Silva  87700
	* @version 1.0
*/
/**
	* inteiro usado para identificar o Service 
*/	
	private final int 	_idService;
/**
	* Custo total que o serviço pode ser 
*/		
	private double		_totalCost;
/**
	* Duração total de um serviço 
*/	
	private Duration 	_totalDuration;
/**
	* Agregação de stop que o serviço é composto 
*/
	private List<Stop> 	_listStops;

/**
	* Construtor que inicializar o serviço
	* @param idService Valor do ID do serviço
	* @param totalCost Valor de custo total do serviço 
*/
	Service (int idService,double totalCost) {
		_idService = idService;
		_totalCost = totalCost;
		_listStops = new ArrayList<>();		
	}
	
/**
	* Funcao que ira retornar a duração entre duas paragens
	* @param startStop Paragem de inicio
	* @param finalStop Paragem de fim
	* @return retorna a duracao total do serviço entre essas duas paragens
	* <br><br> Usado em {@link mmt.core.Service#getCost(Stop start, Stop end)}
*/
	//TODO adicionar verificação se os Stops pertencem à lista
	Duration getDuration(Stop startStop, Stop finalStop){
		return Duration.between(startStop.getSchedule(),finalStop.getSchedule());
	}
/**
	* Funcao que ira retornar o custo total entre duas paragens
	* @param startStop Paragem de inicio
	* @param finalStop Paragem de fim
	* @return retorna um double com o valor total do serviço entre essas duas paragens
	* <br><br> Usa {@link mmt.core.Service#getDuration(Stop start, Stop end)}
*/
	double getCost(Stop startStop, Stop finalStop){			
		return ((getDuration(startStop, finalStop).toMinutes())*_totalCost)/_totalDuration.toMinutes();
	}
/**
	* @return _idService retorna o id do servico 
*/
	int getId(){
		return _idService;
	}
/**
	* Envia uma copia da lista de paragens do Servico
	* @return _listStops lista de stops copiada.
*/
	List<Stop> getStops() {
		return Collections.unmodifiableList(_listStops);
	}


	Stop getStop(Station name){
		for (Stop st : _listStops){
			if (st.getStation().equals(name))
				return st;
		}
		return NULL; //Se nao tiver encontrado nenhuma paragem
	}
/**
	* @return _totalCost retorna o custo total
*/
	double getTotalCost() { return _totalCost; }

/**
	* Funcao de impressao de um servico, e os seus stops.
*/
	public String toString() {
	  String s = String.format(Locale.US,"Serviço #%d @ %.2f\n",
		getId(), getTotalCost());
	  for (Stop st: _listStops) {
	    s = s + st + "\n";
	  }
	  return s.substring(0,s.length() -1);

	  //TODO
	  /* Criar um toString que recebe como argumentos como origem e destino Stops */
	}
/**
	* Funcao que adiciona stops a lista
	* @see mmt.core.Stop
*/
	void addStop(Station stationStop, LocalTime arrivalDate){
		Stop a = new Stop(stationStop, arrivalDate);
		a.setService(this);
		_listStops.add(a);
	}

/**
	* Funcao que indica se dado Stop é paragem de partida aproveita-se que a ordem de insercao da lista <br>
	* e feita de forma ordenada. 
	* @param stp Se for o primeiro da lista indica que e estacao de partida.
*/
	boolean isDeparture(Stop stp) {
		return getStops().indexOf(stp) == 0;
	}
/**
	* Funcao de comparacao natural do Servico, indica que ordenacao crescente.
	* @param s Servico que ira ser comparado com o Servico actual.
	* @return retorna valor positivo, zero ou negativo para indicar a ordem. 
*/
	public int compareTo(Service s){
    	return this.getId() - s.getId();
  }
		
}