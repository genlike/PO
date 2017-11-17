package mmt.core;

import mmt.core.Category;

public class Passenger implements java.io.Serializable{
/**
	* Classe responsavel pelo registo relativo ao passageiro
	* @author Ines Albano	 87664
	* @author Ricardo Silva  87700
	* @version 1.0
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
	private int 		_totalTravelTime;
	private Category 	_category;

/**
   * Contrutor que comeca por identificar o passageiro com o nome
   * Id e' preenchido no TrainCompany
   * @param name do tipo String
   * Usa o metodo setName(name)
   */
	protected Passenger(String name, int id){
		setName(name);
		_id = id;
		_category = new Normal();

	}

/**
   * Devolve o ID do passageiro
   * @return _id do passageiro
   */
	protected int getId(){
		return _id;
	}

/**
   * Devolve o nome do passageiro
   * @return String com o nome do passageiro
   */ 
	protected String getName(){
		return _name;
	}

/**
   * Altera o nome do passageiro com um novo nome
   * @param name do tipo String
   */
	protected void setName(String name){
		_name = name;
	}

/**
   * Devolve categoria a que o passageiro pertence
   * @return categoria do tipo Category
   */
	protected Category getCategory(){
		return _category;
	}

/**
   * Define a categoria do passageiro
   * @param category do tipo Category
   */
	protected void setCategory(Category category){
		_category = category;
	}

/**
   * Devolve a lista de iternerarios do passageiro
   * @return lista de Itenerary
   */
	/*protected Itenerary[] getIteneraryLista(){
		// FIXME implement when Itenerary is developed
	}*/


/**
   * Devolve qual o estado do passageiro
   * @return boolean com o estado
   */
	protected boolean getStatus(){
		return _status;
	}

/**
   * Atualiza o estado do passageiro
   * @param status do tipo boolean
   */
	protected void setStatus(boolean status){
		_status = status;
	}

}
