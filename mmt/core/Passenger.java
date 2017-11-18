package mmt.core;

import java.time.Duration;

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
	private final int 	_id;
	private String 		_name;
	private boolean 	_status;
	private double 		_totalCost;
	private Duration	_totalTravelTime;
	private Category 	_category;
	private int 		_totalItenerary;

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
		return _name;
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
	 Category getCategory(){
		return _category;
	}

/**
   * Define a categoria do passageiro
   * @param category do tipo Category
   */
	 void setCategory(Category category){
		_category = category;
	}

/**
   * Devolve a lista de iternerarios do passageiro
   * @return lista de Itenerary
   */
	/* Itenerary[] getIteneraryLista(){
		// FIXME implement when Itenerary is developed
	}*/


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

	int getTotalItenerary(){
		return _totalItenerary;
	}

	Duration getTotalTime(){
		return _totalTravelTime;
	}

@Override

	public String toString(){
		return String.format("%d|%s|%s|%d|%d|{0:HH:mm}", 
			getId(), getName(), getCategory(), getTotalItenerary(), 0, getTotalTime());
	}

	public int compareTo(Passenger p){
    	return this.getId() - p.getId();
  }

}
