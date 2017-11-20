package mmt.core;

public abstract class Category implements java.io.Serializable {
/**
	* Classe responsavel pelo registo da categoria relativa ao passageiro
	* @author Ines Albano	 87664
	* @author Ricardo Silva  87700
	* @version 1.0
	*/

/**
	* _description atributo que ira guardar qual a categoria do passageiro
	* _discount atibuto que contem o desconto relativo a cada categoria
	*/
	private String _description;
	private double _discount;


/**
   * Construtor preenche a descricao
   * O desconto e' preenchido de acordo com a categoria
   * @param description do tipo String
   */
	 Category(String description){
		_description = description;
	}

/**
   * Devolve a categoria 
   * @return _description do tipo String
   */
	 String getCategoryDescription(){
		return "" + _description;
	}

/**
   * Define qual o desconto relativo a uma dada categoria
   * @param description do tipo String
   */
	 protected void setDiscount(double value){
		_discount = value;		
	}

/**
   * Devolve qual o desconto relativo a cada categoria 
   * @return _discount do tipo double
   */
	double getDiscount(){
		return _discount;
	}

	@Override
	public String toString(){
		return "" + _description;
	}






}
