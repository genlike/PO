package mmt.core;

import java.time.Duration;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class Passenger implements java.io.Serializable, Comparable<Passenger>{
/**
	* Classe responsavel pelo registo relativo ao passageiro
	* @author Ines Albano	 87664
	* @author Ricardo Silva  87700
	* @version 1.0
	* Todos os metodos sao package-private logo nao e' explicitado o nivel de acesso
	*/

/**
	* _id atributo relativo ao id do passageiro
	* _name atributo relativo ao nome do passageiro
	* _status atributo relativo ao estado - ativo/invativo - do passageiro
	* _totalCost custo total dos percursos percorrido pelo passageiro
	* _totalTravelTime tempo total percorrido pelos percursos do passageiro
	* _category categoria - normal/frequente/especial - do passageiro
	*/
	private final int 		_id;
	private String 			_name;
	private boolean 		_status;
	private double 			_totalCost;
	private Duration		_totalTravelTime;
	private Category 		_category;
	private Set<Itinerary> 	_setItinerary;
	private Itinerary[]		_lastTenItinerary;
	private int 			_contadorIter;

/**
   * Contrutor que comeca por identificar o passageiro com o nome
   * Id e' preenchido no TrainCompany
   * @param name do tipo String
   * Usa o metodo setName(name)
   */
	 Passenger(int id, String name){
		setName(name);
		_id = id;
		_category = new Normal();
		_totalTravelTime = Duration.ZERO;
		_setItinerary = new TreeSet<>();
		_lastTenItinerary = new Itinerary[10];
		_contadorIter = 0;
	}

/**
   * Devolve o ID do passageiro
   * @return _id do passageiro
   */
	 int getId(){
		return _id;
	}

/**
   * Devolve o nome do passageiro
   * @return String com o nome do passageiro
   */ 
	 String getName(){
		return "" + _name;
	}

/**
   * Altera o nome do passageiro com um novo nome
   * @param name do tipo String
   */
	 void setName(String name){
		_name = name;
	}

/**
   * Devolve categoria a que o passageiro pertence
   * @return categoria do tipo Category
   */
	 String getCategory(){
		return _category.getCategoryDescription();
	}

/**
   * Define a categoria do passageiro
   * @param category do tipo Category
   */
	 void setCategory(Category category){
		_category = category;
	}

/**
   * Define a categoria do passageiro baseado no custo dos itenerarios adquiridos
   */
	void sortCategory(){
		double discountedCost = getTotalCost();

		if (discountedCost <= 250){
		  if (!(getCategory().equals(Normal.DESCRIPTION))) { setCategory(new Normal()); }
		}
		else if (discountedCost <= 2500){
		  if (!(getCategory().equals(Frequent.DESCRIPTION))) { setCategory(new Frequent()); }
		}
		else {
		  if (!(getCategory().equals(Special.DESCRIPTION))) { setCategory(new Special()); }
		}
  	}


/**
   * Devolve qual o estado do passageiro
   * @return boolean com o estado
   */
	 boolean getStatus(){
		return _status;
	}

/**
   * Atualiza o estado do passageiro
   * @param status do tipo boolean
   */
	 void setStatus(boolean status){
		_status = status;
	}

/**
   * Devolve totais itenerarios comprados pelo passageiro
   * @return inteiro com o _totalItenerary
   */
	int getTotalItenerary(){
		return _contadorIter;
	}

/**
   * Devolve tempo total que um passageiro comprou
   * @return tempo total viajado
   */
	Duration getTotalTime(){
		return _totalTravelTime;
	}


/**
   * Devolve total pago pelo passageiro
   * @return double com o valor pago
   */
	double getTotalCost() {
		double discountedCost = 0;
		for (Itinerary it : _lastTenItinerary)
			if (it != null ) { discountedCost += it.getTotalCost(); }
		return discountedCost; 
	}

/**
	* Impressao formatada de um passageiro
	*/
	@Override
	public String toString(){
	  return String.format(Locale.US,"%d|%s|%s|%d|%.2f|%02d:%02d", 
	  getId(), getName(), getCategory(), getTotalItenerary(), _totalCost,
	  getTotalTime().toHours(),(getTotalTime().toMinutes())%60);
	}

/**
	* Metodo de comparacao de clientes pelos seus ids, ordenecao crescente
	* @return retorna um valor inteiro positivo, zero ou negativo, para indicar se e maior ou menor que o passageiro dado.
	*/
	public int compareTo(Passenger p){
	  return this.getId() - p.getId();
	}

/**
	* Metodo de trata de registar a compra de um itenerario para um cliente
	*/
	void buyItinerary(Itinerary it){
		_setItinerary.add(it);

		_totalTravelTime = _totalTravelTime.plus(it.getTotalDuration());

		_lastTenItinerary[(_contadorIter++)%10] =  it;

		_totalCost += it.getTotalCost()* _category.getPartOfPayingPrice();

		sortCategory();
	}

/**
   * Devolve a lista de iternerarios do passageiro
   * @return lista de Itenerary
   */
	
	Collection<Itinerary> getItineraries() { return Collections.unmodifiableSet(_setItinerary); }

	String printItineraries(){
		String s = "== Passageiro " + getId() + ": " + getName() + " ==\n";
		int i = 1;
		Collection<Itinerary> colItinerary = getItineraries();

		if (colItinerary.size() == 0) { return null; }

      		for (Itinerary it : colItinerary)
      			s += "\n" +it.toString(i++) + "\n";

      		return s.substring(0,s.length() -1);
	}

}